package controller;

import entity.Matchup;
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

@WebServlet("/getSchedule")
public class GetSpecificSchedule extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // List to hold matchups
        List<List<String>> schedule = new ArrayList<>();
        // Get the matchup Dao
        Dao<Matchup> MATCHUP_DAO = new Dao<>(Matchup.class);
        // Get the scheduleID and number of weeks from the request param
        int scheduleId = Integer.parseInt(request.getParameter("scheduleId"));
        int numberOfWeeks = Integer.parseInt(request.getParameter("numberOfWeeks"));

        List<Matchup> matchups = MATCHUP_DAO.findByPropertyEqual("scheduleId", scheduleId);

        int currentWeek = 1;

        for (Matchup matchup : matchups) {
            List<String> matchupsForWeek = new ArrayList<>();

            while(currentWeek <= numberOfWeeks) {
                if (matchup.getWeekNumber() == currentWeek) {
                    String currentMatchup = matchup.getTeam1() + " vs. " + matchup.getTeam2();
                    matchupsForWeek.add(currentMatchup);
                }
                schedule.add(matchupsForWeek);
                currentWeek++;
            }
        }

        request.setAttribute("schedule", schedule);

        RequestDispatcher view = request.getRequestDispatcher("showSavedSchedule.jsp");
        view.forward(request, response);
    }
}
