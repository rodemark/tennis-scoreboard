package com.rodemark.controllers;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "matches", value = "/matches")
public class MatchesController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){

    }
}
