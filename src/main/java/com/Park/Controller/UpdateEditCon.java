package com.Park.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Park.Bo.Staff_bo;
import com.Park.Dao.Emp_Dao;


@WebServlet("/UpdateEditCon")
public class UpdateEditCon extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String job = request.getParameter("job");
		String doj = request.getParameter("doj");
		String doc = request.getParameter("doc");

		Staff_bo em=new Staff_bo();
		em.setId(id);
		em.setName(name);
		em.setPhone(email);
		em.setEmail(phone);
		em.setJob(doj);
		em.setDoj(doj);
		em.setDoc(doc);
		int status =Emp_Dao.Edit(em);
		if(status>0) {
			RequestDispatcher rd=request.getRequestDispatcher("ViewStaff_Controller");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("EditServlet");
			rd.include(request, response);
		}
		
}
}