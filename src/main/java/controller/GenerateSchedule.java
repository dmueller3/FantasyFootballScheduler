package controller;

import java.util.*;

public class GenerateSchedule {
    private int numberOfWeeks;
    private List<String> selectedTeams;
    private int matchupFrequency;
    private Map<String, List<Integer>> previousMatchups;
    private List<List<String>> schedule;

    public GenerateSchedule(int numberOfWeeks, List<String> selectedTeams, int matchupFrequency, Map<String, List<Integer>> previousMatchups, List<List<String>> schedule) {
        this.numberOfWeeks = numberOfWeeks;
        this.selectedTeams = selectedTeams;
        this.matchupFrequency = matchupFrequency;
        this.previousMatchups = previousMatchups;
        this.schedule = schedule;
    }

    public void scheduleCreation() {
        // Loop until the number of weeks scheduled equals the numberOfWeeks
        for (int weekNumber = 1; weekNumber < numberOfWeeks; weekNumber++) {
            final int TEAMS_PER_MATCHUP = 2;
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
                if (matchupValidity(matchup)) {
                    matchupsForWeek.add(matchup);
                    teamsNotAssigned.remove(0);
                    teamsNotAssigned.remove(1);
                } else {
                    Collections.shuffle(teamsNotAssigned);
                }
            }
            schedule.add(new ArrayList<>(matchupsForWeek));
        }
    }

    public boolean matchupValidity(String matchup) {
        return true;
    }
}
