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
@WebServlet("/scheduleDisplay")
public class DisplayScheduleServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        int numberOfWeeks = (int) session.getAttribute("numberOfWeeks");
        List<String> teams = (ArrayList<String>) session.getAttribute("teams");
        int matchupFrequency = (int) session.getAttribute("matchupFrequency");

        GenerateSchedule scheduler = new GenerateSchedule(numberOfWeeks, teams, matchupFrequency);
        scheduler.scheduleCreation();

        List<List<String>> generatedSchedule = schedule.getSchedule();
        request.setAttribute("schedule", generatedSchedule);

        RequestDispatcher dispatcher = request.getRequestDispatcher("scheduleResult.jsp");
        dispatcher.forward(request, response);
    }
}
