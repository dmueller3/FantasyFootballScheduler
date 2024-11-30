package controller;

import persistence.TeamDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(
        urlPatterns = {"/generationSettings"}
)
public class ScheduleGenerationSettings extends HttpServlet {
    // Instantiate the logger
    private final Logger logger = LogManager.getLogger(this.getClass());

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
        TeamDao teamDao = new TeamDao();
        session.setAttribute("teams", teamDao.getAll());

        // Get the form inputs
        int numberOfTeams = Integer.parseInt(request.getParameter("numberTeams"));
        int numberOfWeeks = Integer.parseInt(request.getParameter("numberWeeks"));
        int matchupFrequency = Integer.parseInt(request.getParameter("frequencyPlayed"));

        // Log the inputs from the form
        logger.info("Number of teams: {}", numberOfTeams);
        logger.info("Number of weeks: {}", numberOfWeeks);
        logger.info("Matchup frequency: {}", matchupFrequency);

        // Store the form values in the request
        request.setAttribute("numberOfTeams", numberOfTeams);
        request.setAttribute("numberOfWeeks", numberOfWeeks);
        request.setAttribute("matchupFrequency", matchupFrequency);

        // Send the redirect to the form where team names are entered
        request.getRequestDispatcher("teamNames.jsp").forward(request, response);
    }
}