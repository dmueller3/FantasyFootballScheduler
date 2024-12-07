package controller;

import entity.Team;
import persistence.Dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * The type Add new team.
 */
@WebServlet("/addTeamServlet")
public class AddNewTeam extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dao<Team> TEAM_DAO = new Dao<>(Team.class);

        String teamName = request.getParameter("teamName");
        String teamOwner = request.getParameter("teamOwner");

        Team team = new Team(teamName, teamOwner);
        TEAM_DAO.insert(team);

        request.setAttribute("teamName", teamName);
        request.setAttribute("teamOwner", teamOwner);

        RequestDispatcher view = request.getRequestDispatcher("teamAdded.jsp");
        view.forward(request, response);
    }

}
