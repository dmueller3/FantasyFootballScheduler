package entity;

import persistence.TeamDao;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet(
        urlPatterns = {"/generationSettings"}
)
public class ScheduleGenerationSettings extends HttpServlet {

    /**
     *  Handles HTTP POST requests.
     *
     *@param  request               Description of the Parameter
     *@param  response              Description of the Parameter
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        // Reference the servlet context
        ServletContext context = getServletContext();

        GenerateSchedule generateSchedule = (GenerateSchedule) context.getAttribute("generateSchedule");

        int numberOfTeams = Integer.parseInt(request.getParameter("numberOfTeams"));
        int numberOfWeeks = Integer.parseInt(request.getParameter("numberOfWeeks"));
        int matchupFrequency = Integer.parseInt(request.getParameter("matchupFrequency"));

        generateSchedule.getSettings(numberOfTeams, numberOfWeeks, matchupFrequency);

        String url = "/teamNames.jsp";

        request.getRequestDispatcher(url).forward(request, response);
    }
}