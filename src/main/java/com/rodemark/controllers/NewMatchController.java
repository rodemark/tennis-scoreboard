package com.rodemark.controllers;

import com.rodemark.models.MatchScoreModel;
import com.rodemark.models.Player;
import com.rodemark.other.AppInitializer;
import com.rodemark.services.OngoingMatchesService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "NewMatchController", value = "/new-match")
public class NewMatchController extends HttpServlet {
    private OngoingMatchesService ongoingMatchesService;
    @Override
    public void init(ServletConfig config) {
        ongoingMatchesService = AppInitializer.getOngoingMatchesService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/jsp/new-match.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String nameOfPlayerFirst = request.getParameter("player1");
            String nameOfPlayerSecond = request.getParameter("player2");

            MatchScoreModel matchScoreModel = new MatchScoreModel();
            matchScoreModel.setPlayerFirst(new Player(nameOfPlayerFirst));
            matchScoreModel.setPlayerSecond(new Player(nameOfPlayerSecond));
            ongoingMatchesService.startNewMatch(matchScoreModel);
            String redirectUrl = String.format("%s/match-score?uuid=%s", request.getContextPath(), matchScoreModel.getUuid());
            response.sendRedirect(redirectUrl);

        } catch (Exception exception) {
            request.setAttribute("exception_message", exception.getMessage());
            request.getRequestDispatcher("view/jsp/error.jsp").forward(request, response);
        }
    }
}
