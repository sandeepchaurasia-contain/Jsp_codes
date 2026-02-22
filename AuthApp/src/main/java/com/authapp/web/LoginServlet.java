package com.authapp.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws IOException, ServletException {

	    String u = req.getParameter("username");
	    String p = req.getParameter("password");

	    try (Connection con = DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PASS);
	         PreparedStatement ps =
	           con.prepareStatement("SELECT id FROM users WHERE username=? AND password=?")) {

	      ps.setString(1, u);
	      ps.setString(2, p);
	      
	      ResultSet rs=ps.executeQuery();
	      
	      if(rs.next()) {
	    	  
	    	  	req.getSession().setAttribute("user", u);
	    	  	resp.sendRedirect("dashboard.jsp");
	      }
	      else {
	    	  	  req.setAttribute("error", "Invalid credentials");
	          req.getRequestDispatcher("login.jsp").forward(req, resp);
	      }
	    }catch(SQLException e) {
	    		throw new ServletException(e);
	    }
	}
}
