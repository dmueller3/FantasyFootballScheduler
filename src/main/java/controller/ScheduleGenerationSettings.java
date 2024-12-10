package controller;

import entity.Team;
import persistence.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;

/**
 * The type Schedule generation settings.
 */
@WebServlet(
        urlPatterns = {"/generationSettings"}
)
public class ScheduleGenerationSettings extends HttpServlet {

    /**
     *  Handles HTTP POST requests.
     *
     *@param  request               Description of the Parameter
     *@param  response              Description of the Parameter
     *@exception  IOException       if there is an IO failure
     */
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {

        // Reference the session
        HttpSession session = request.getSession();

        // Get the team names from the database
        Dao<Team> TEAM_DAO = new Dao<>(Team.class);
        session.setAttribute("teams", TEAM_DAO.getAll());

        // Get the form inputs
        String numberOfTeams = request.getParameter("numberTeams");
        String numberOfWeeks = request.getParameter("numberWeeks");
        String matchupFrequency = request.getParameter("frequencyPlayed");

        // Store the form values in the request
        session.setAttribute("numberOfTeams", numberOfTeams);
        session.setAttribute("numberOfWeeks", numberOfWeeks);
        session.setAttribute("matchupFrequency", matchupFrequency);

        // Send the redirect to the form where team names are entered
        response.sendRedirect("teamNames.jsp");
    }
}