package controller;

import entity.Schedule;
import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.Dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * The type Add schedule to history.
 */
@WebServlet("/addSchedule")
public class AddScheduleToHistory extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Reference the session
        HttpSession session = request.getSession();

        // Get the values
        Dao<User> USER_DAO = new Dao<>(User.class);
        String userName = (String) session.getAttribute("userName");
        List<User> user = USER_DAO.findByPropertyEqual("userName", userName);
        int userID = user.get(0).getUser_id();
        logger.info("user id " + userID);
        int numberOfTeams = Integer.parseInt((String) session.getAttribute("numberOfTeams"));
        logger.info("number of teams " + numberOfTeams);
        int numberOfWeeks = Integer.parseInt((String) session.getAttribute("numberOfWeeks"));
        logger.info("number of weeks " + numberOfWeeks);
        int matchupFrequency = Integer.parseInt((String) session.getAttribute("matchupFrequency"));
        logger.info("matchupFrequency " + matchupFrequency);

        LocalDateTime currentDate = LocalDateTime.now();
        logger.info("current date " + currentDate);

        Dao<Schedule> SCHEDULE_DAO = new Dao<>(Schedule.class);
        Schedule schedule = new Schedule(userID, currentDate, numberOfWeeks, numberOfTeams, matchupFrequency);

        int scheduleID = SCHEDULE_DAO.insert(schedule);

        AddMatchups addMatchups = new AddMatchups();

        List<List<String>> generatedSchedule = (List<List<String>>) session.getAttribute("schedule");
        addMatchups.addMatchupsToDatabase(generatedSchedule, scheduleID);

        RequestDispatcher view = request.getRequestDispatcher("scheduleAdded.jsp");
        view.forward(request, response);
    }

}
