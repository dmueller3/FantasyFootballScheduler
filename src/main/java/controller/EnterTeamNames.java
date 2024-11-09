package controller;

import persistence.TeamDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Allows the user to enter the teams for the schedule maker
 * @author Derek Mueller
 */
@WebServlet(
        urlPatterns = {"/enterNames"}
)
public class EnterTeamNames extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the teams from the database
        TeamDao teamDao = new TeamDao();

        // Collect the number of teams from the session
        HttpSession session = request.getSession();
        int numberOfTeams = (int) session.getAttribute("numberOfTeams");

        request.setAttribute("numberOfTeams", numberOfTeams); // change later
        request.setAttribute("teams", teamDao.getAll());

        // Get the values from this form for team names
        String firstTeam = request.getParameter("firstTeam");
        String secondTeam = request.getParameter("secondTeam");
        String thirdTeam = request.getParameter("thirdTeam");
        String fourthTeam = request.getParameter("fourthTeam");

        // Handle if there are more than 4 teams
        if (numberOfTeams >= 6) {
            String fifthTeam = request.getParameter("fifthTeam");
            String sixthTeam = request.getParameter("sixthTeam");
        }
        if (numberOfTeams >= 8) {
            String seventhTeam = request.getParameter("seventhTeam");
            String eighthTeam = request.getParameter("eighthTeam");
        }
        if (numberOfTeams == 10) {
            String ninthTeam = request.getParameter("ninthTeam");
            String tenthTeam = request.getParameter("tenthTeam");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("scheduleResult.jsp");
        dispatcher.forward(request, response);
    }
}
