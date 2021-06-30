package controller;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "HomePageServlet", urlPatterns = {"/homePage",""})
public class HomePageServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.sendRedirect("home_page.jsp");
    }
}