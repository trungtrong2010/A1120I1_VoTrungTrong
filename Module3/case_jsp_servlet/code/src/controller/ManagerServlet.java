package controller;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = {"/manager", ""})
public class ManagerServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.sendRedirect("home_page.jsp");
    }
}
