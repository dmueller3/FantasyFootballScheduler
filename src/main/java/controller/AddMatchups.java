package controller;

import entity.Matchup;
import persistence.Dao;

import javax.servlet.http.HttpSession;
import java.util.List;

public class AddMatchups {
    Dao<Matchup> MATCHUP_DAO = new Dao<>(Matchup.class);

    public void addMatchupsToDatabase(List<List<String>> schedule, int scheduleID) {
        int weekNumber = 1;

        for (List<String> week : schedule) {
            for (String matchup : week) {
                /*
                Used Peter Mortensen's answer to split the matchups into teams:
                https://stackoverflow.com/questions/3481828/how-do-i-split-a-string-in-java?page=2&tab=scoredesc
                 */
                String[] teams = matchup.split(" vs. ");
                String team1 = teams[0];
                String team2 = teams[1];

                // Create and insert a Matchup into the database
                Matchup matchupInfo = new Matchup(team1, team2, weekNumber, scheduleID);
                MATCHUP_DAO.insert(matchupInfo);
            }
            weekNumber++;
        }
    }

}
