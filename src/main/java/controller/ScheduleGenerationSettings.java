package controller;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;

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

        // Get the form inputs
        int numberOfTeams = Integer.parseInt(request.getParameter("numberTeams"));
        int numberOfWeeks = Integer.parseInt(request.getParameter("numberWeeks"));
        int matchupFrequency = Integer.parseInt(request.getParameter("frequencyPlayed"));

        // Store the form values in the session
        HttpSession session = request.getSession();
        session.setAttribute("numberOfTeams", numberOfTeams);
        session.setAttribute("numberOfWeeks", numberOfWeeks);
        session.setAttribute("matchupFrequency", matchupFrequency);

        // Send the redirect to the form where team names are entered
        response.sendRedirect("teamNames.jsp");
    }
}