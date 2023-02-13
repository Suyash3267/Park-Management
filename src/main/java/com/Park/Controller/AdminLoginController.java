package com.Park.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Park.Dao.Emp_Dao;



 
@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String username_Login = request.getParameter("email");
		String pwd_Login = request.getParameter("password");

		if (Emp_Dao.userLogin(username_Login, pwd_Login)) {

			pw.println("Successfully Logined");
			try {
				pw.println("Redirecting to home page....");
				RequestDispatcher rd = request.getRequestDispatcher("Home.html");
				rd.forward(request, response);
			} catch (Exception e) {
				System.out.println(e);
			}

		} else {
			pw.println("<script> alert(\"Login failed\");</script>");

			RequestDispatcher rd = request.getRequestDispatcher("MainLogin.html");
			rd.forward(request, response);

		}

	}

	}


