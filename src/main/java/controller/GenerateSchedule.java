package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Takes a number of weeks, team names, and matchup frequency and generates a schedule
 *
 * @author Derek Mueller
 */
public class GenerateSchedule {
    private final int numberOfWeeks;
    private final List<String> selectedTeams;
    private final int matchupFrequency;
    private final Map<String, List<Integer>> previousMatchups;
    private final List<List<String>> schedule;
    private final List<String> shuffleHistory;

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Constructor to get values of the weeks, teams, and matchup frequency
     * @param numberOfWeeks the number of weeks in the schedule
     * @param selectedTeams the teams selected for this schedule
     * @param matchupFrequency the number of weeks before a matchup can be repeated
     */
    public GenerateSchedule(int numberOfWeeks, List<String> selectedTeams, int matchupFrequency) {
        // Get the values from the constructor
        this.numberOfWeeks = numberOfWeeks;
        this.selectedTeams = new ArrayList<>(selectedTeams);
        this.matchupFrequency = matchupFrequency;

        // Instantiate local variables
        this.previousMatchups = new HashMap<>();
        this.schedule = new ArrayList<>();
        this.shuffleHistory = new ArrayList<>();
    }

    public void scheduleCreation() {
        // Loop until the number of weeks scheduled equals the numberOfWeeks
        for (int weekNumber = 1; weekNumber <= numberOfWeeks; weekNumber++) {
            List<String> matchupsForWeek = new ArrayList<>();
            List<String> teamsNotAssigned = new ArrayList<>(selectedTeams);


            /* Used Hamza Khan's response here for shuffling an arraylist
             * https://stackoverflow.com/questions/16112515/how-to-shuffle-an-arraylist
             */
            do {
                Collections.shuffle(teamsNotAssigned);
            } while (shuffleHistory.contains(teamsNotAssigned.toString()));

            shuffleHistory.add(teamsNotAssigned.toString());
            if (shuffleHistory.size() > matchupFrequency) {
                shuffleHistory.remove(0);
            }

            while (!teamsNotAssigned.isEmpty()) {
                // Select the first 2 teams in the list
                String team1 = teamsNotAssigned.get(0);
                String team2 = teamsNotAssigned.get(1);
                String matchup = team1 + " vs. " + team2;

                // Check if the matchup is valid based on the history
                if (matchupValidity(team1, team2, weekNumber)) {
                    matchupsForWeek.add(matchup);

                    // Track matchup and the week it occurred
                    String key1 = team1 + " vs. " + team2;
                    String key2 = team2 + " vs. " + team1;
                    previousMatchups.putIfAbsent(key1, new ArrayList<>());
                    previousMatchups.putIfAbsent(key2, new ArrayList<>());
                    previousMatchups.get(key1).add(weekNumber);
                    previousMatchups.get(key2).add(weekNumber);

                    // Remove the teams
                    teamsNotAssigned.remove(0);
                    // Index is reset to 0
                    teamsNotAssigned.remove(0);
                    logger.info("teams not assigned: " + teamsNotAssigned);
                } else {
                    Collections.shuffle(teamsNotAssigned);
                }
            }
            logger.info("Matchups for week " + weekNumber + ": " + matchupsForWeek);
            schedule.add(matchupsForWeek);
        }
    }

    public boolean matchupValidity(String team1, String team2, int currentWeek) {
        String matchupKey1 = team1 + " vs. " + team2;
        String matchupKey2 = team2 + " vs. " + team1;

        // Retrieve the history for both matchup orders
        List<Integer> history1 = previousMatchups.getOrDefault(matchupKey1, Collections.emptyList());
        List<Integer> history2 = previousMatchups.getOrDefault(matchupKey2, Collections.emptyList());

        // Check if either history violates the matchup frequency rule
        return (history1.isEmpty() || currentWeek - history1.get(history1.size() - 1) >= matchupFrequency)
                && (history2.isEmpty() || currentWeek - history2.get(history2.size() - 1) >= matchupFrequency);
    }


    public List<List<String>> getSchedule() {
        return schedule;
    }
}
