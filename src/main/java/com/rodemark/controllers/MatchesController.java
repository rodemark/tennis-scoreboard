package com.rodemark.controllers;

import com.rodemark.models.Match;
import com.rodemark.services.MatchesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "matches", value = "/matches")
public class MatchesController extends HttpServlet {
    private MatchesService matchesService;
    @Override
    public void init() {
        this.matchesService = new MatchesService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Match> matches;
        String playerName = request.getParameter("playerName");

        if (playerName != null && !playerName.isEmpty()){
            matches = matchesService.getMatchesByPlayerName(playerName);
        }
        else{
            matches = matchesService.getAllMatches();
        }

        request.setAttribute("matches", matches);
        request.setAttribute("matchesService", matchesService);

        request.getRequestDispatcher("view/jsp/matches.jsp").forward(request, response);
    }
}
