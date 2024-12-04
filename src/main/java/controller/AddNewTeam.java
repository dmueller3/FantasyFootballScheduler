package controller;

import entity.TeamNames;
import persistence.TeamDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/addTeamServlet")
public class AddNewTeam extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeamDao teamDao = new TeamDao();

        String teamName = request.getParameter("teamName");
        String teamOwner = request.getParameter("teamOwner");

        TeamNames team = new TeamNames(teamName, teamOwner);
        teamDao.insert(team);

        request.setAttribute("teamName", teamName);
        request.setAttribute("teamOwner", teamOwner);

        RequestDispatcher view = request.getRequestDispatcher("teamAdded.jsp");
        view.forward(request, response);
    }

}
