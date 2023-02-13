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


@WebServlet("/AddStaff_Controller")
public class AddStaff_Controller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			
			String name=request.getParameter("name");
			String phone=request.getParameter("phone");
			String email=request.getParameter("email");
			String job=request.getParameter("job");
			String doj=request.getParameter("doj");
			String doc=request.getParameter("doc");
			
			//pw.write(name+"<br>"+phone+"<br>"+adhaar+"<br>"+dob+"<br>"+job+"<br>"+doj+"<br>");
			
			Staff_bo obj=new Staff_bo(name, phone, email, job, doj, doc);
			//pw.write(obj.getName()+"<br>"+obj.getPhone()+"<br>"+obj.getAdhaar()+"<br>"+obj.getDob()+"<br>"+obj.getJob()+"<br>"+obj.getDoj()+"<br>");
			
			if(Emp_Dao.addEmp(obj)>0) {
				pw.write("<h3>Data Fetch Succesfully</h3>");
				RequestDispatcher rd=request.getRequestDispatcher("ViewStaff_Controller");
				rd.forward(request, response);
			}
			else {
				pw.write("<h3>Something Went Wrong<h/3>");
				RequestDispatcher rd=request.getRequestDispatcher("AddStaff_Controller");
				rd.include(request, response);
			}
			
			
		}

	}

	

