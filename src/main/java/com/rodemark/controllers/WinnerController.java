package com.rodemark.controllers;

import com.rodemark.other.AppInitializer;
import com.rodemark.services.OngoingMatchesService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "WinnerController", value = "/winner")
public class WinnerController extends HttpServlet {
    private OngoingMatchesService ongoingMatchesService;

    @Override
    public void init(ServletConfig config) {
        ongoingMatchesService = AppInitializer.getOngoingMatchesService();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String winnerName = request.getParameter("winnerName");
        UUID uuid = UUID.fromString(request.getParameter("uuid"));
        try {
            ongoingMatchesService.removeMatch(uuid);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("winner", winnerName);
        request.getRequestDispatcher("view/jsp/winner.jsp").forward(request, response);
    }
}
