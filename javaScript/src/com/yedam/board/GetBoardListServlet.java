package com.yedam.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/GetBoardListServlet")
public class GetBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetBoardListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONObject obj = new JSONObject();
		JSONArray ary = new JSONArray();
		BoardDAO dao = new BoardDAO();
		for (Board b : dao.getBoardList()) {
			obj.put("Board_no", b.getBoardNumber());
			
			obj.put("Content", b.getContent());
			obj.put("Writer", b.getWriter());
			obj.put("CreateDate", b.getCreateDate());
			ary.add(obj);
		}
		PrintWriter out = response.getWriter();
		out.print(ary.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
