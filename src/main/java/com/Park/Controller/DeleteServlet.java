package com.Park.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Park.Dao.Emp_Dao;



@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		
pw.print("asfsfasgasdfg");
	      String id=request.getParameter("id");
	      int eid= Integer.parseInt(id);
	      
	    int status = Emp_Dao.Delete(eid);
		
//	    RequestDispatcher rd=request.getRequestDispatcher("ViewEmpController");
//		rd.forward(request, response);
response.sendRedirect("ViewStaff_Controller");
	
	
	
	}

}
