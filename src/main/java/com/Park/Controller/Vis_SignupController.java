package com.Park.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Park.Bo.Vis_bo;
import com.Park.Dao.Emp_Dao;



@WebServlet("/Vis_SignupController")
public class Vis_SignupController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pass");
		String age=request.getParameter("age");
		String enq=request.getParameter("enq");
		
		pw.print(name+" <br>"+phone+" <br>"+email+"<br> "+pwd+"<br> ");
		
		Vis_bo em=new Vis_bo();
		
		em.setName(name);
		em.setEmail(email);
		em.setPhone(phone);
		em.setPass(pwd);
		em.setAge(age);
		em.setEnq(enq);
		
		
		int status= Emp_Dao.signup(em);
		
		if(status>0) {
				pw.write("Data Added Successfully");
				RequestDispatcher rd=request.getRequestDispatcher("MainLogin.html");
				rd.forward(request, response);
}
		else {
			pw.write("Something went wrong");
			RequestDispatcher rd=request.getRequestDispatcher("Vis_Signup.html");
			rd.include(request, response);
		}
	}

}
