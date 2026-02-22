package com.authapp.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/db-test")
public class DbTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/plain");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // force driver load

            try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/authapp?useSSL=false&serverTimezone=UTC",
                    "root", "root123")) { // <-- apna user/pass

                resp.getWriter().println("DB CONNECTED OK");
            }

        } catch (Exception e) {
            resp.getWriter().println("DB FAILED: " + e.getMessage());
        }
    }
}