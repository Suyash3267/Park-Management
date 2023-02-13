package com.Park.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Park.Bo.Emp_Bo;
import com.Park.Bo.Staff_bo;
import com.Park.Dao.Emp_Dao;


@WebServlet("/ViewStaff_Controller")
public class ViewStaff_Controller extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		pw.print("<a href='home.html'>Back</a><br><br><br>");

		
		//Saving Account
		
		pw.print("<center style='font-weight: bold;'>All Employees<center>");
		pw.print("<br><br>");
		
		pw.print("<table border='solid' width='100%' style=' border-collapse: collapse; '> ");

		 pw.print("<tr> <th> Id </th> <th> Name </th> <th> Phone </th> <th> Email </th> <th> Job</th> <th> Date Of Joining</th> <th> Documents Submitted</th><th> Action </th></tr>");

//		Staff_bo obj2 = Emp_Bo.view();
		List<Staff_bo> list = Emp_Dao.AllEmployee();
		

			for (Staff_bo eb : list) {

				   pw.print("<tr><td>"+eb.getId()+"</td><td>"+eb.getName()+"</td><td>"+eb.getPhone()+"</td><td>"+eb.getEmail()+"</td><td>"+eb.getJob()+"</td><td>"+eb.getDoj()+"</td><td>"+eb.getDoc()+"</td><td>"+"<a href='EditServlet?id="+eb.getId()+"'> edit </a></td> <td><a href='DeleteServlet?id="+eb.getId()+"'>delete </a></td></tr>"); 	  

			}
//			pw.print("<tr  style= 'font-weight: bold;'><td></td><td>Final Balance = "+obj2.getSav()+"</td></tr>");
			pw.print("</table>");
		
			
		
	}

}
