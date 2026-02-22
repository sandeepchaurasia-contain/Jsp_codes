package myJsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws IOException, ServletException {

        String user = req.getParameter("username");
        req.setAttribute("user", user);

        req.getRequestDispatcher("home3.jsp").forward(req, resp);
	}

}
