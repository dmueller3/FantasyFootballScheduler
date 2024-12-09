package controller;

import entity.Schedule;
import persistence.Dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * The type Add schedule to history.
 */
@WebServlet("/addSchedule")
public class AddScheduleToHistory {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Reference the session
        HttpSession session = request.getSession();

        // Get the values
        int userID = (int)session.getAttribute("userID");
        int numberOfTeams = Integer.parseInt((String) session.getAttribute("numberOfTeams"));
        int numberOfWeeks = Integer.parseInt((String) session.getAttribute("numberOfWeeks"));
        int matchupFrequency = Integer.parseInt((String) session.getAttribute("matchupFrequency"));

        String currentDate = LocalDate.now().toString();

        Dao<Schedule> SCHEDULE_DAO = new Dao<>(Schedule.class);
        Schedule schedule = new Schedule(userID, currentDate, numberOfTeams, numberOfWeeks, matchupFrequency);

        int scheduleID = SCHEDULE_DAO.insert(schedule);

        AddMatchups addMatchups = new AddMatchups();

        List<List<String>> generatedSchedule = (List<List<String>>) session.getAttribute("schedule");
        addMatchups.addMatchupsToDatabase(generatedSchedule, scheduleID);

        RequestDispatcher view = request.getRequestDispatcher("scheduleAdded.jsp");
        view.forward(request, response);
    }

}
