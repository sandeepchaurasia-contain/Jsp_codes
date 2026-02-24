package com.aryan.email;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/send")
public class SendMailServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String to = req.getParameter("to");
        String subject = req.getParameter("subject");
        String msg = req.getParameter("msg");

        try {
            EmailService.send(to, subject, msg);
            resp.getWriter().println("Email sent successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Failed to send email: " + e.getMessage());
        }
    }
}