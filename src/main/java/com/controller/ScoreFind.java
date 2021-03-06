package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.ScoreBiz;
import com.entity.Score;

//@WebServlet("/ScoreFind")
public class ScoreFind extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		Score my_score = new ScoreBiz().getScoreFind(name);
		
		request.setAttribute("find", my_score);
		RequestDispatcher rd = request.getRequestDispatcher("ScoreUpdate.jsp");
		rd.forward(request, response);
	}


}
