package com.rodemark.controllers;

import com.rodemark.DTO.MatchDTO;
import com.rodemark.models.Player;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "NewMatchController", value = "/new-match")
public class NewMatchController extends HttpServlet {

    @Override
    public void init(ServletConfig config) {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/jsp/new-match.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameOfPlayerFirst = request.getParameter("player1");
        String nameOfPlayerSecond = request.getParameter("player2");


    }
}
