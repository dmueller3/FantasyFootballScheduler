package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Reference the session
        HttpSession session = request.getSession();

        // Get the values
        int numberOfTeams = Integer.parseInt((String) session.getAttribute("numberOfTeams"));
        int numberOfWeeks = Integer.parseInt((String) session.getAttribute("numberOfWeeks"));
        int matchupFrequency = Integer.parseInt((String) session.getAttribute("matchupFrequency"));

        // Log the values
        logger.info("Number of teams " + numberOfTeams);
        logger.info("Number of weeks " + numberOfWeeks);
        logger.info("Matchup frequency " + matchupFrequency);

        // Instantiate a list to hold the teams
        List<String> teams = new ArrayList<>();

        for (int i = 0; i < numberOfTeams; i++) {
            String teamName = request.getParameter("team" + (i + 1));
            logger.info("Team " + (i + 1) + ": " + teamName);
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
