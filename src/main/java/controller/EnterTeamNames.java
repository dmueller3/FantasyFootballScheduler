package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * Allows the user to enter the teams for the schedule maker
 * @author Derek Mueller
 */
@WebServlet("/enterNames")
public class EnterTeamNames extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Reference the session
        HttpSession session = request.getSession();

        // Get the values
        int numberOfTeams = Integer.parseInt((String) session.getAttribute("numberOfTeams"));
        int numberOfWeeks = Integer.parseInt((String) session.getAttribute("numberOfWeeks"));
        int matchupFrequency = Integer.parseInt((String) session.getAttribute("matchupFrequency"));

        // Instantiate a list to hold the teams
        List<String> teams = new ArrayList<>();

        for (int i = 1; i < numberOfTeams; i++) {
            String teamName = request.getParameter("team" + i);
            teams.add(teamName);
        }

        GenerateSchedule scheduler = new GenerateSchedule(numberOfWeeks, teams, matchupFrequency);
        scheduler.scheduleCreation();

        List<List<String>> generatedSchedule = scheduler.getSchedule();
        request.setAttribute("schedule", generatedSchedule);

        RequestDispatcher dispatcher = request.getRequestDispatcher("scheduleResult.jsp");
        dispatcher.forward(request, response);
    }
}
