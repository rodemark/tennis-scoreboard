package com.rodemark.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "MatchScoreController", value = "/match-score")
public class MatchScoreController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, ServletException, IOException {
        request.getRequestDispatcher("view/jsp/match-score.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, ServletException, IOException {

    }
}
