package com.rodemark.controllers;

import com.rodemark.models.Match;
import com.rodemark.repositories.DAO.MatchDAO;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "NewMatchController", value = "/new-match")
public class NewMatchController extends HttpServlet {

    @Override
    public void init(ServletConfig config) {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/jsp.new-match.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response){
        Match match = new Match();
    }
}
