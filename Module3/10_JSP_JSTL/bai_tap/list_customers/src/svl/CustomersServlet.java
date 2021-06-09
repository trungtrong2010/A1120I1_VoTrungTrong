package svl;

import jv.Customers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomersServlet", urlPatterns = "/listCustomer")
public class CustomersServlet extends HttpServlet {
    private static List<Customers> listCustomers;
    static {
        listCustomers = new ArrayList<>();
        listCustomers.add(new Customers("Võ Trung Trọng",1,"1999-10-20","Quảng Nam","avatar.png"));
        listCustomers.add(new Customers("Trần Thanh Phương",1,"1985-01-01","Đà Nẵng","avatar_1.jpg"));
        listCustomers.add(new Customers("Trần Lý Mỹ Hạnh",0,"1992-10-10","Đà Nẵng","avatar_3.jpg"));
        listCustomers.add(new Customers("Doãn Mạnh Thắng",1,"1996-12-12","Đà Nẵng","avatar_1.jpg"));
        listCustomers.add(new Customers("Quỳnh Như",0,"2000-01-01","Thanh Hóa","avatar_4.jpg"));
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCustomers",listCustomers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/show.jsp");
        dispatcher.forward(request, response);
    }
}
