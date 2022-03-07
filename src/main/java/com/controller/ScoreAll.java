package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.ScoreBiz;
import com.entity.Score;


@WebServlet("/ScoreAll")
public class ScoreAll extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Score> all = new ScoreBiz().getScoreAll();
		
		request.setAttribute("all", all);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("ScoreAll.jsp");
		rd.forward(request,response);
	}
}
