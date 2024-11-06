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
            List<String> matchupsForWeek = new ArrayList<>();
            List<String> teamsNotAssigned = new ArrayList<>();

            /* Used Hamza Khan's response here for shuffling an arraylist
             * https://stackoverflow.com/questions/16112515/how-to-shuffle-an-arraylist
             */
            Collections.shuffle(teamsNotAssigned);


        }
    }
}
