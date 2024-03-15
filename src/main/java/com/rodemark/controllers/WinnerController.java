package com.rodemark.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "WinnerController", value = "/winner")
public class WinnerController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String winnerName = request.getParameter("winnerName");

        request.setAttribute("winner", winnerName);
        request.getRequestDispatcher("view/jsp/winner.jsp").forward(request, response);
    }
}
