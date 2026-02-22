package com.authapp.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String u=req.getParameter("username");
		String p=req.getParameter("password");
		
		if(u==null || u.trim().isEmpty() || p==null || p.trim().isEmpty()) {
			req.setAttribute("error","Username & Password required...");
			req.getRequestDispatcher("register.jsp").forward(req,resp);
			return;
		}
		
		try (
			Connection con=DriverManager.getConnection(DBConfig.URL,DBConfig.USER,DBConfig.PASS);
			PreparedStatement ps=con.prepareStatement("INSERT INTO users(username,password) VALUES(?,?)")){
				
			ps.setString(1, u);
			ps.setString(2, p);
			ps.executeUpdate();
			
			resp.sendRedirect("login.jsp");
		}catch (SQLException e) {
		    e.printStackTrace(); // console me real error dikhega
		    req.setAttribute("error", "ERROR: " + e.getMessage());
		    req.getRequestDispatcher("register.jsp").forward(req, resp);
		}
	
		
	}

}
