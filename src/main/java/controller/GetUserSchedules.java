package controller;

import entity.User;
import entity.Schedule;
import persistence.Dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/scheduleHistory")
public class GetUserSchedules extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Reference the session
        HttpSession session = request.getSession();

        // Get the ID for the logged in user
        Dao<User> USER_DAO = new Dao<>(User.class);
        String userName = "dmueller3"; //(String) session.getAttribute("userName");
        List<User> user = USER_DAO.findByPropertyEqual("userName", userName);
        int userID = user.get(0).getUser_id();

        // Get schedule info for the logged in user
        Dao<Schedule> SCHEDULE_DAO = new Dao<>(Schedule.class);
        List<Schedule> savedSchedules = SCHEDULE_DAO.findByPropertyEqual("user_id", userID);

        List<String> scheduleDetails = new ArrayList<>();
        for (Schedule schedule : savedSchedules) {
            String dateCreated = schedule.getDateOfCreation().toString();
            int scheduleID = schedule.getId();
            int numberOfWeeks = schedule.getNumberOfWeeks();

            String scheduleLink = "<a href='getSchedule?scheduleID=" + scheduleID + "&numberOfWeeks=" + numberOfWeeks
                    + "'>" + "Schedule generated: " + dateCreated + "</a>" + scheduleID;

            scheduleDetails.add(scheduleLink);
        }

        request.setAttribute("scheduleDetails", scheduleDetails);

        RequestDispatcher view = request.getRequestDispatcher("savedSchedules.jsp");
        view.forward(request, response);
    }
}
