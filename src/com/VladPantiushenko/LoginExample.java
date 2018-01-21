package com.VladPantiushenko;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class LoginExample extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        try {

            String login = request.getParameter("login");
            String pass = request.getParameter("password");

            String defaultLogin = "admin";
            String defaultPassword = "admin";

            if(login.equals(defaultLogin) && pass.equals(defaultPassword))
            {
                out.println("Welcome, " + login);
            }
            else
            {
                RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
                rs.include(request, response);
                out.println("Username or Password is incorrect");
            }

        } finally {

            out.close();

        }

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        processRequest(request, response);

    }

}