package controller;

import entity.Matchup;
import entity.Team;
import entity.User;
import persistence.Dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Get specific schedule.
 */
@WebServlet("/getSchedule")
public class GetSpecificSchedule extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // List to hold matchups
        List<List<String>> schedule = new ArrayList<>();
        // Get the Dao
        Dao<Matchup> MATCHUP_DAO = new Dao<>(Matchup.class);
        Dao<Team> TEAM_DAO = new Dao<>(Team.class);

        // Get the scheduleID and number of weeks from the request param
        int scheduleID = Integer.parseInt(request.getParameter("scheduleID"));
        int numberOfWeeks = Integer.parseInt(request.getParameter("numberOfWeeks"));

        List<Matchup> matchups = MATCHUP_DAO.findByPropertyEqual("scheduleID", scheduleID);

        // Initialize the schedule with empty lists for each week
        for (int i = 0; i < numberOfWeeks; i++) {
            schedule.add(new ArrayList<>());
        }

        // Add the weekly matchups
        for (Matchup matchup : matchups) {
            int weekNumber = matchup.getWeekNumber();
            if (weekNumber >= 1 && weekNumber <= numberOfWeeks) {
                // Get the team names
                List<Team> team1Name = TEAM_DAO.findByPropertyEqual("id", matchup.getTeam1());
                String team1 = team1Name.get(0).getTeamName();
                List<Team> team2Name = TEAM_DAO.findByPropertyEqual("id", matchup.getTeam2());
                String team2 = team2Name.get(0).getTeamName();

                String currentMatchup = team1 + " vs. " + team2;
                schedule.get(weekNumber - 1).add(currentMatchup);
            }
        }

        request.setAttribute("schedule", schedule);

        RequestDispatcher view = request.getRequestDispatcher("showSavedSchedule.jsp");
        view.forward(request, response);
    }
}
