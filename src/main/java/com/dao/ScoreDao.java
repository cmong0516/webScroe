package com.dao;

import static com.common.JdbcTemplate.close;
import static com.common.JdbcTemplate.commit;
import static com.common.JdbcTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.Score;

public class ScoreDao implements ScoreSql {

	Connection con;

	public ScoreDao(Connection con) {
		this.con = con;
	}

	public List<Score> getScoreAll() {
		// select 의 결과를 한줄씩 담을 객체.
		Score myscore = null;

		List<Score> all = new ArrayList<>();

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(Score_selectAll);

			while (rs.next()) {
				myscore = new Score();
				myscore.setName(rs.getString(1));
				myscore.setKor(rs.getInt(2));
				myscore.setEng(rs.getInt(3));
				myscore.setMat(rs.getInt(4));

				all.add(myscore);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}

		return all;
	}

	public int getScoreInsert(Score my_score) {
		PreparedStatement pstm = null;
		int res = 0;

		try {
			pstm = con.prepareStatement(Score_insert);
			pstm.setString(1, my_score.getName());
			pstm.setInt(2, my_score.getKor());
			pstm.setInt(3, my_score.getEng());
			pstm.setInt(4, my_score.getMat());
			pstm.setInt(5, my_score.getTot());
			pstm.setDouble(6, my_score.getAvg());
			pstm.setString(7, my_score.getGrade());

			res = pstm.executeUpdate();

			if (res > 0)
				commit(con);

		} catch (Exception e) {
			rollback(con);
			e.printStackTrace();
		} finally {
			close(pstm);
		}
		return res;
	}

	public int getScoredelete(String name) {
		PreparedStatement pstm = null;
		int res = 0;

		try {
			pstm = con.prepareStatement(Score_delete);
			pstm.setString(1, name);

			res = pstm.executeUpdate();

			if (res > 0)
				commit(con);

		} catch (Exception e) {
			rollback(con);
			e.printStackTrace();
		} finally {
			close(pstm);
		}
		return res;

	}

	public Score getScoreFind(String name) {
		Score myscore = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement(Score_find);
			stmt.setString(1, name);
			rs = stmt.executeQuery();

			while (rs.next()) {
				myscore = new Score();
				myscore.setName(rs.getString(1));
				myscore.setKor(rs.getInt(2));
				myscore.setEng(rs.getInt(3));
				myscore.setMat(rs.getInt(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}

		return myscore;
	}

	public int getScoreUpdate(Score my_score) {
		PreparedStatement pstm = null;
		int res = 0;

		try {
			pstm = con.prepareStatement(Score_update);

			pstm.setInt(1, my_score.getKor());
			pstm.setInt(2, my_score.getEng());
			pstm.setInt(3, my_score.getMat());
			pstm.setString(4, my_score.getName());

			res = pstm.executeUpdate();

			if (res > 0)
				commit(con);

		} catch (Exception e) {
			rollback(con);
			e.printStackTrace();
		} finally {
			close(pstm);
		}
		return res;
	}

}