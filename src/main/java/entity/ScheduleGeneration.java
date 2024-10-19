package entity;

import persistence.TeamDao;

import java.util.ArrayList;
import java.util.List;

public class ScheduleGeneration {
    private int numberOfTeams;
    private int numberOfWeeks;
    private int matchupFrequency;
    List<TeamNames> teams;

    public void getTeams() {
        teams = TeamDao.getAll();
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public void setNumberOfTeams(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    public int getNumberOfWeeks() {
        return numberOfWeeks;
    }

    public void setNumberOfWeeks(int numberOfWeeks) {
        this.numberOfWeeks = numberOfWeeks;
    }

    public int getMatchupFrequency() {
        return matchupFrequency;
    }

    public void setMatchupFrequency(int matchupFrequency) {
        this.matchupFrequency = matchupFrequency;
    }
}
