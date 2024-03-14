package com.rodemark.controllers;

import com.rodemark.models.MatchScoreModel;
import com.rodemark.other.AppInitializer;
import com.rodemark.services.MatchScoreService;
import com.rodemark.services.OngoingMatchesService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "MatchScoreController", value = "/match-score")
public class MatchScoreController extends HttpServlet {
    private OngoingMatchesService ongoingMatchesService;

    @Override
    public void init(ServletConfig config) {
        ongoingMatchesService = AppInitializer.getOngoingMatchesService();
        MatchScoreService matchScoreService = new MatchScoreService(ongoingMatchesService);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, ServletException, IOException {
        try {
            UUID uuid = UUID.fromString(request.getParameter("uuid"));
            MatchScoreModel match = ongoingMatchesService.getMatchByUUID(uuid);
            request.setAttribute("match", match);
            request.getRequestDispatcher("view/jsp/match-score.jsp").forward(request, response);
        } catch (Exception exception) {
            request.setAttribute("exception_message", exception.getMessage());
            request.getRequestDispatcher("view/jsp/error.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, ServletException, IOException {
        try {
            UUID uuid = UUID.fromString(request.getParameter("uuid"));
            MatchScoreModel currentMatch = ongoingMatchesService.getMatchByUUID(uuid);

        }
        catch (Exception exception){
            request.setAttribute("exception_message", exception.getMessage());
            request.getRequestDispatcher("view/jsp/error.jsp").forward(request, response);
        }
    }
}
