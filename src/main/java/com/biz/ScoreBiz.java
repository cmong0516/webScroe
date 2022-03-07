package com.biz;



import java.sql.Connection;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.dao.ScoreDao;
import com.entity.Score;
import static com.common.JdbcTemplate.*;


@WebServlet("/ScoreBiz")
public class ScoreBiz extends HttpServlet {
	
	

	public List<Score> getScoreAll() {
		Connection conn = getConnection();
		List<Score> all = new ScoreDao(conn).getScoreAll();
		
		close(conn);
		
		return all;
	}

	public int getScoreInsert(Score my_score) {
		Connection conn = getConnection();
		int res = new ScoreDao(conn).getScoreInsert(my_score);
		
		close(conn);
		return res;
	}

	public int getScoredelete(String name) {
		Connection conn = getConnection();
		int res = new ScoreDao(conn).getScoredelete(name);
		
		close(conn);
		return res;
		
	}
	
	public Score getScoreFind(String name) {
		Connection conn = getConnection();
		Score res = new ScoreDao(conn).getScoreFind(name);
		close(conn);
		return res;
	}
	
	public int getScoreUpdate(Score my_score) {
		Connection conn = getConnection();
		int res = new ScoreDao(conn).getScoreUpdate(my_score);
		close(conn);
		return res;
	}

}
