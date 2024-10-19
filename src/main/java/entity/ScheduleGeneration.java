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

    
}
