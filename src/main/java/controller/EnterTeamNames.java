package controller;

import persistence.TeamDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
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
        TeamDao teamDao = new TeamDao();

        request.setAttribute("teams", teamDao.getAll());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/teamNames.jsp");
        dispatcher.forward(request, response);
    }
}
