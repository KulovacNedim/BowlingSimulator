package main.java.com.projectnedim.controller;

import main.java.com.projectnedim.model.Game;
import main.java.com.projectnedim.service.GameService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/simulate")
public class SimulateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher success = req.getRequestDispatcher("view/index.jsp");
        success.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GameService gameService = new GameService();

        int skillLevel = Integer.parseInt(req.getParameter("skill"));

        int numberOfGames = Integer.parseInt(req.getParameter("games"));

        List<Game> games = gameService.getSimulatedGames(skillLevel, numberOfGames);

        req.setAttribute("simulatedGames", games);
        req.setAttribute("skillLevel", skillLevel);

        RequestDispatcher success = req.getRequestDispatcher("view/index.jsp");
        success.forward(req, resp);
    }
}
