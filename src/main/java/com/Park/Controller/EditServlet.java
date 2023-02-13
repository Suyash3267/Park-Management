package com.Park.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Park.Bo.Staff_bo;
import com.Park.Dao.Emp_Dao;




/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		 
	      String id=request.getParameter("id");
        
	      int eid= Integer.parseInt(id);
	    
	      Staff_bo eb= Emp_Dao.getEmployeeById(eid);
	    
		 
		pw.print("<form  action='UpdateEditCon' method='get'> ");
	    
		pw.print("<table>");
		
		pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+eb.getId()+"'/></td></tr>");  
		pw.print("<tr><td>Name: </td> <td><input type='text' name='name' value='"+eb.getName()+"'/></td></tr>");
	   	pw.print("<tr><td>Phone: </td> <td><input type='text' name='phone' value='"+eb.getPhone()+"'/></td></tr>");
	   	pw.print("<tr><td>Email:</td> <td><input type='text' name='email' value='"+eb.getEmail()+"'/></td></tr>");
	   	pw.print("<tr><td>Job : </td> <td><input type='text' name='job' value='"+eb.getJob()+"'/></td></tr>");
	   	pw.print("<tr><td>Date of Joining: </td> <td><input type='date' name='doj' value='"+eb.getDoj()+"'/></td></tr>");
	   	pw.print("<tr><td>Documents: </td> <td><input type='text' name='adhaar' value='"+eb.getDoc()+"'/></td></tr>");
		
	    pw.print("<tr><td><input type='submit' value='Edit '/></td></tr>"); 
	    
	   	pw.print("</table>");
		
		pw.print("</form>");	}	

}
