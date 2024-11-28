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
        // Instantiate a list to hold the teams
        List<String> teams = new ArrayList<>();

        // Collect the number of teams from the session
        HttpSession session = request.getSession();
        int numberOfTeams = (int) session.getAttribute("numberOfTeams");

        for (int i = 0; i < numberOfTeams; i++) {
            String teamName = request.getParameter("team" + i);
            teams.add(teamName);
        }

        session.setAttribute("teams", teams);

        /*
        // Get the values from this form for team names
        String firstTeam = request.getParameter("team1");
        String secondTeam = request.getParameter("team2");
        String thirdTeam = request.getParameter("team3");
        String fourthTeam = request.getParameter("team4");

        // Handle if there are more than 4 teams
        if (numberOfTeams >= 6) {
            String fifthTeam = request.getParameter("team5");
            String sixthTeam = request.getParameter("team6");
        }
        if (numberOfTeams >= 8) {
            String seventhTeam = request.getParameter("team7");
            String eighthTeam = request.getParameter("team8");
        }
        if (numberOfTeams == 10) {
            String ninthTeam = request.getParameter("team9");
            String tenthTeam = request.getParameter("team10");
        }

         */

        RequestDispatcher dispatcher = request.getRequestDispatcher("scheduleResult.jsp");
        dispatcher.forward(request, response);
    }
}
