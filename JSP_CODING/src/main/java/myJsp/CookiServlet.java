package myJsp;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/save-cookie")
public class CookiServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws IOException{
		Cookie c=new Cookie("user","Aryan");
		c.setMaxAge(60*60);
		resp.addCookie(c);
		resp.getWriter().println("Cookie saved");
	}

}
