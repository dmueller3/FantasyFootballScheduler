package controller;

import entity.Matchup;
import entity.Team;
import persistence.Dao;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * The type Add matchups.
 */
public class AddMatchups {
    /**
     * The Matchup dao.
     */
    Dao<Matchup> MATCHUP_DAO = new Dao<>(Matchup.class);
    /**
     * The Team dao.
     */
    Dao<Team> TEAM_DAO = new Dao<>(Team.class);

    /**
     * Add matchups to database.
     *
     * @param schedule   the schedule
     * @param scheduleID the schedule id
     */
    public void addMatchupsToDatabase(List<List<String>> schedule, int scheduleID) {
        int weekNumber = 1;

        for (List<String> week : schedule) {
            for (String matchup : week) {
                /*
                Used Peter Mortensen's answer to split the matchups into teams:
                https://stackoverflow.com/questions/3481828/how-do-i-split-a-string-in-java?page=2&tab=scoredesc
                 */
                String[] teams = matchup.split(" vs. ");
                List<Team> team1Name = TEAM_DAO.findByPropertyEqual("teamName", teams[0]);
                int team1 = team1Name.get(0).getId();
                List<Team> team2Name = TEAM_DAO.findByPropertyEqual("teamName", teams[1]);
                int team2 = team2Name.get(0).getId();

                // Create and insert a Matchup into the database
                Matchup matchupInfo = new Matchup(team1, team2, weekNumber, scheduleID);
                MATCHUP_DAO.insert(matchupInfo);
            }
            weekNumber++;
        }
    }

}
