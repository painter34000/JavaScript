package com.yedam.dev;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetEmpListServlet")
public class GetEmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetEmpListServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		//response.getWriter().append("Served at: ").append(request.getContextPath()).append(" Hong");
		
		EmpDAO dao = new EmpDAO();
		List<Employee> empList = dao.getEmpList();
		
//		[
//		{"id":1,"first_name":"Jaquelyn","last_name":"Staves","email":"jstaves0@narod.ru","gender":"Female","ip_address":"31.163.102.55"},
//		{"id":2,"first_name":"Evaleen","last_name":"Langfitt","email":"elangfitt1@craigslist.org","gender":"Female","ip_address":"86.24.109.115"},
//		{"id":3,"first_name":"Gerta","last_name":"Freen","email":"gfreen2@youtube.com","gender":"Female","ip_address":"137.162.33.207"},
//		{"id":4,"first_name":"Tris","last_name":"Kilner","email":"tkilner3@cdbaby.com","gender":"Male","ip_address":"173.237.245.218"},
//		{"id":5,"first_name":"Leanna","last_name":"Quilty","email":"lquilty4@acquirethisname.com","gender":"Female","ip_address":"209.38.247.140"}
//		]
		
		String empJson = "[";
		
		int rCnt =0;
		int totalCnt = empList.size();
		for(Employee e : empList) {
			empJson += "{\"empId\":"+e.getEmployeeId()
			+",\"firstName\":\""+e.getFirstName()
			+"\",\"lastName\":\""+e.getLastName()
			+"\"}";
			if(++rCnt != totalCnt)
			empJson +=",";
		
		}
	empJson+="]";
	PrintWriter out = response.getWriter();
	out.print(empJson.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
