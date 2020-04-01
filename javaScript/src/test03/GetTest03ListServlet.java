package com.yedam.test03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/GetTest03ListServlet")
public class GetTest03ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetTest03ListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONObject obj = new JSONObject();
		JSONArray ary = new JSONArray();
		BoardDAO dao = new BoardDAO();
		for (Board b : dao.getBoardList()) {
			obj.put("Department_no", b.getDepartment_no());
			
			obj.put("Department_Id", b.getDepartment_Id());
			obj.put("Department_name", b.getDepartment_name());
			obj.put("CreateDate", b.getCreateDate());
			ary.add(obj);
		}
		PrintWriter out = response.getDepartment_name();
		out.print(ary.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
