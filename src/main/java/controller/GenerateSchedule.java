package controller;

import java.util.*;

/**
 * Takes a number of weeks, team names, and matchup frequency and generates a schedule
 *
 * @author Derek Mueller
 */
public class GenerateSchedule {
    private static final int TEAMS_PER_MATCHUP = 2;
    private final int numberOfWeeks;
    private final List<String> selectedTeams;
    private final int matchupFrequency;
    private final Map<String, List<Integer>> previousMatchups;
    private final List<List<String>> schedule;

    public GenerateSchedule(int numberOfWeeks, List<String> selectedTeams, int matchupFrequency) {
        this.numberOfWeeks = numberOfWeeks;
        this.selectedTeams = new ArrayList<>(selectedTeams);
        this.matchupFrequency = matchupFrequency;
        this.previousMatchups = new HashMap<>(previousMatchups);
        this.schedule = new ArrayList<>(schedule);
    }

    public void scheduleCreation() {
        // Loop until the number of weeks scheduled equals the numberOfWeeks
        for (int weekNumber = 1; weekNumber <= numberOfWeeks; weekNumber++) {
            List<String> matchupsForWeek = new ArrayList<>();
            List<String> teamsNotAssigned = new ArrayList<>(selectedTeams);

            /* Used Hamza Khan's response here for shuffling an arraylist
             * https://stackoverflow.com/questions/16112515/how-to-shuffle-an-arraylist
             */
            Collections.shuffle(teamsNotAssigned);

            while (teamsNotAssigned.size() >= TEAMS_PER_MATCHUP) {
                String team1 = teamsNotAssigned.get(0);
                String team2 = teamsNotAssigned.get(1);
                String matchup = team1 + " vs. " + team2;

                // Check if the matchup is valid based on the history
                if (matchupValidity(team1, team2, weekNumber)) {
                    matchupsForWeek.add(matchup);

                    // Track matchup and the week it occurred
                    String key1 = team1 + "-" + team2;
                    String key2 = team2 + "-" + team1;
                    previousMatchups.putIfAbsent(key1, new ArrayList<>());
                    previousMatchups.putIfAbsent(key2, new ArrayList<>());
                    previousMatchups.get(key1).add(weekNumber);
                    previousMatchups.get(key2).add(weekNumber);

                    teamsNotAssigned.remove(0);
                    // Index is reset to 0
                    teamsNotAssigned.remove(0);
                } else {
                    Collections.shuffle(teamsNotAssigned);
                }
            }
            schedule.add(matchupsForWeek);
        }
    }

    public boolean matchupValidity(String team1, String team2, int currentWeek) {
        String matchupKey1 = team1 + "-" + team2;
        String matchupKey2 = team2 + "-" + team1;

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
