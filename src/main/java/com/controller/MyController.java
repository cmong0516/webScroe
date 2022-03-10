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

@WebServlet({ "/MyController", "/ScoreAll", "/ScoreDelete", "/ScoreFind", "/ScoreInput", "/ScoreUpdate" })
public class MyController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getRequestURI();

		if (url.endsWith("ScoreAll")) {
			doScoreAll(request, response);
		} else if (url.endsWith("ScoreUpdate")) {
			doScoreUpdate(request, response);
		} else if (url.endsWith("ScoreDelete")) {
			doScoreDelete(request, response);
		} else if (url.endsWith("ScoreFind")) {
			doScoreFind(request, response);
		} else if (url.endsWith("ScoreInput")) {
			doScoreInput(request, response);
		}

	}

	protected void doScoreAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Score> all = new ScoreBiz().getScoreAll();

		request.setAttribute("all", all);

		// ScoreAll 로 요청했지만 ScoreAll.jsp 로 request,response를 전송하며 ScoreAll.jsp 를 보여준다.
		RequestDispatcher rd = request.getRequestDispatcher("ScoreAll.jsp");
		rd.forward(request, response);
	}

	protected void doScoreDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int r = new ScoreBiz().getScoredelete(request.getParameter("name"));
		if (r > 0)
			response.sendRedirect("ScoreAll");
	}

	protected void doScoreFind(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		Score my_score = new ScoreBiz().getScoreFind(name);

		request.setAttribute("find", my_score);
		RequestDispatcher rd = request.getRequestDispatcher("ScoreUpdate.jsp");
		rd.forward(request, response);
	}

	protected void doScoreInput(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Score my_score = new Score();
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		my_score.setName(name);
		my_score.setKor(kor);
		my_score.setEng(eng);
		my_score.setMat(mat);

		ScoreBiz biz = new ScoreBiz();
		int r = biz.getScoreInsert(my_score);
		if (r > 0) {
			response.sendRedirect("ScoreAll");
		}
	}

	protected void doScoreUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));

		Score my_score = new Score(name, kor, eng, mat);

		int r = new ScoreBiz().getScoreUpdate(my_score);

		if (r > 0)
			response.sendRedirect("ScoreAll");
	}

}
