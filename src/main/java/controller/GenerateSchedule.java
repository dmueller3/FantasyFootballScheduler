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
    }

    /**
     * Main method that is called to begin schedule generation.
     * Log an error if the schedule constraints are invalid
     */
    public void scheduleCreation() {
        if (!createSchedule(1)) {
            logger.error("Unable to generate a valid schedule");
        }
    }

    /**
     * As long as the current week is less than the number of the weeks, call the schedule generation method
     * and add the weekly matchups to the schedule. End once the number of weeks threshold has been met
     *
     * @param week the current week being generated
     * @return true if the current week is less than the number of weeks
     */
    public boolean createSchedule(int week) {
        // Check if the current week exceeds the number of weeks
        if (week > numberOfWeeks) {
            return true;
        }

        // Instantiate lists for the weekly matchups and selected teams
        List<String> matchupsForWeek = new ArrayList<>();
        List<String> teamsNotAssigned = new ArrayList<>(selectedTeams);

        /* Used Hamza Khan's response here for shuffling an arraylist
         * https://stackoverflow.com/questions/16112515/how-to-shuffle-an-arraylist
         *
         * Randomize the list
         */
        Collections.shuffle(teamsNotAssigned);

        // Call the generation method. Add matchups if valid, otherwise remove a week from the schedule.
        if (generateWeekSchedule(teamsNotAssigned, matchupsForWeek, week)) {
            schedule.add(new ArrayList<>(matchupsForWeek));
            if (createSchedule(week + 1)) {
                return true;
            }
            schedule.remove(schedule.size() - 1);
        }
        // Randomize the teams again
        Collections.shuffle(selectedTeams);

        // End the method once the current week exceeds the number of weeks
        return false;
    }

    private boolean generateWeekSchedule(List<String> teamsNotAssigned, List<String> matchupsForWeek, int currentWeek) {
        if (teamsNotAssigned.isEmpty()) {
            return true;
        }

        List<int[]> possiblePairs = new ArrayList<>();
        for (int i = 1; i < teamsNotAssigned.size(); i++) {
            int[] pair = {0, i};
            possiblePairs.add(pair);
        }

        Collections.shuffle(possiblePairs);

        for (int[] pair : possiblePairs) {
            String team1 = teamsNotAssigned.get(pair[0]);
            String team2 = teamsNotAssigned.get(pair[1]);
            String matchup = team1 + " vs. " + team2;

            if (matchupValidity(team1, team2, currentWeek)) {
                matchupsForWeek.add(matchup);
                trackMatchup(team1, team2, currentWeek);

                teamsNotAssigned.remove(pair[1]); // Remove by index (higher first)
                teamsNotAssigned.remove(pair[0]);

                if (generateWeekSchedule(teamsNotAssigned, matchupsForWeek, currentWeek)) {
                    return true;
                }

                teamsNotAssigned.add(pair[0], team1);
                teamsNotAssigned.add(pair[1] - 1, team2);
                matchupsForWeek.remove(matchupsForWeek.size() - 1);
                untrackMatchup(team1, team2);
            }
        }
        return false;
    }

    private void trackMatchup(String team1, String team2, int week) {
        String key1 = team1 + " vs. " + team2;
        String key2 = team2 + " vs. " + team1;
        previousMatchups.putIfAbsent(key1, new ArrayList<>());
        previousMatchups.putIfAbsent(key2, new ArrayList<>());
        previousMatchups.get(key1).add(week);
        previousMatchups.get(key2).add(week);
    }

    private void untrackMatchup(String team1, String team2) {
        String key1 = team1 + " vs. " + team2;
        String key2 = team2 + " vs. " + team1;
        previousMatchups.get(key1).remove(previousMatchups.get(key1).size() - 1);
        previousMatchups.get(key2).remove(previousMatchups.get(key2).size() - 1);
    }

    public boolean matchupValidity(String team1, String team2, int currentWeek) {
        String matchupKey1 = team1 + " vs. " + team2;
        String matchupKey2 = team2 + " vs. " + team1;

        List<Integer> history1 = previousMatchups.getOrDefault(matchupKey1, Collections.emptyList());
        List<Integer> history2 = previousMatchups.getOrDefault(matchupKey2, Collections.emptyList());

        return (history1.isEmpty() || currentWeek - history1.get(history1.size() - 1) >= matchupFrequency)
                && (history2.isEmpty() || currentWeek - history2.get(history2.size() - 1) >= matchupFrequency);
    }

    public List<List<String>> getSchedule() {

        return schedule;
    }
}
