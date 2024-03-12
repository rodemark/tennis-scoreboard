package com.rodemark.controllers;

import com.rodemark.repositories.DAO.MatchDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "matches", value = "/matches")
public class MatchesController extends HttpServlet {
    private MatchDAO matchDAO;
    @Override
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response){

    }
}
