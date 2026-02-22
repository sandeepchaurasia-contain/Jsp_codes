package myJsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet  extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws IOException, ServletException {
		
		String username=req.getParameter("username");
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC","root", "password");
		
			PreparedStatement ps =con.prepareStatement("INSERT INTO users(username) VALUES(?)");
			ps.setString(1, username);
			ps.executeUpdate();

			ps.close();
			con.close();

			req.setAttribute("msg", "User saved");
			req.getRequestDispatcher("result.jsp").forward(req, resp);
		}catch(Exception e) {
			throw new ServletException(e);
		
		}
		
	}
}
