package com.yedam.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

	Connection conn = null;

	public BoardDAO() {
		String user = "hr";
		String pass = "hr";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Board> getBoardList() {
		String sql = "Select * from Board order by board_no desc";
		List<Board> list = new ArrayList<>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql); // 오라클에서 해석해서 담음
			ResultSet rs = pstmt.executeQuery(); // executeQuery:쿼리를 처리함. ResultSet에 결과값 담음
			while (rs.next()) {
				Board b = new Board();
				b.setBoardNumber(rs.getInt("board_no"));
				b.setContent(rs.getString("content"));
				b.setCreateDate(rs.getString("create_date"));
				b.setWriter(rs.getString("writer"));

				list.add(b);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list; // 리턴값 주의
	}
	
	public Board getBoardInfo(int BoardNo){
		String sql = "select board_no , content, writer, create_date from board " + 
				"where board_no = ? ";
		Board brd = new Board();
		try {  //try 문에서 에러가 나면 catch문으로 결과값 송출
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, BoardNo);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				brd.setBoardNumber(rs.getInt("board_no"));
				brd.setContent(rs.getString("content"));
				brd.setCreateDate(rs.getString("create_date"));
				brd.setWriter(rs.getString("writer"));
			}
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return brd;	
	}	

	public void insertBoard(Board b) {
		String sql = "insert into board \r\n" + "values( (select nvl(max(board_no),0)+1 from board)\r\n"
				+ "         , ? -- 글내용\r\n" + "         , ?  -- 작성자\r\n" + "         , sysdate)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getContent());
			pstmt.setString(2, b.getWriter());
			int iCnt = pstmt.executeUpdate();
			System.out.println(iCnt + "건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
