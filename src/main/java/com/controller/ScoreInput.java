package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.ScoreBiz;
import com.entity.Score;

//@WebServlet("/ScoreInput")
public class ScoreInput extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		if(r>0) {
			response.sendRedirect("ScoreAll");
		}
	}


}
