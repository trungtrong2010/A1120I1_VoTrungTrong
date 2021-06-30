package controller;

import model.customer.Customer;
import model.customer.CustomerType;
import service.customer.CustomerService;
import service.customer.CustomerServiceImpl;
import service.customer.CustomerTypeService;
import service.customer.CustomerTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            case "findCustomerById":
                findCustomerById(request, response);
                break;
            default:
                showListCustomer(request, response);
                break;
        }
    }

    private void findCustomerById(HttpServletRequest request, HttpServletResponse response) {
//        int id = 0;
//        try {
//            id = Integer.parseInt(request.getParameter("id"));
//        } catch (NumberFormatException e) {
//            e.getMessage();
//            showListCustomer(request, response);
//            return;
//        }
//        Customer customer = customerService.getCustomerById(id);
//        request.setAttribute("customer", customer);
//        try {
//            request.getRequestDispatcher("customer/listCustomer.jsp").forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
        String name = request.getParameter("name");
        if (name.equals("")) {
            showListCustomer(request, response);
        } else {
            List<Customer> list = customerService.getCustomerByName(name);
            if (list.size() != 0) {
                request.setAttribute("listCustomerFindByName", list);
            } else {
                request.setAttribute("searchName", "not found");
            }
            request.setAttribute("findName",name);
            try {
                request.getRequestDispatcher("customer/listCustomer.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int idType = Integer.parseInt(request.getParameter("idType"));
        CustomerType customerType = customerTypeService.findCustomerTypeById(idType);
        Customer customer = new Customer(id, name, birthday, gender, idCard, phone, email, address, customerType);
//        RequestDispatcher dispatcher;
//        if (!customer.toString().equals(customerService.getCustomerById(id).toString())) {
        customerService.update(id, customer);
//            request.setAttribute("id", id);
//            dispatcher = request.getRequestDispatcher("customer/listCustomer.jsp");
        showListCustomer(request, response);
//        } else {
//            request.setAttribute("message","Chưa có thay đổi gì !!!");
//            dispatcher = request.getRequestDispatcher("customer/edit.jsp");
//        }
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = (int) (Math.random() * 10000);
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int idType = Integer.parseInt(request.getParameter("idType"));
        CustomerType customerType = customerTypeService.findCustomerTypeById(idType);
        Customer customer = new Customer(id, name, birthday, gender, idCard, phone, email, address, customerType);
        customerService.save(customer);
        showListCustomer(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateCustomerForm(request, response);
                break;
            case "edit":
                showEditCustomerForm(request, response);
                break;
            case "delete":
                removeCustomer(request, response);
                break;
            default:
                showListCustomer(request, response);
                break;
        }
    }

    private void removeCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.delete(id);
        showListCustomer(request, response);
    }

    private void showEditCustomerForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.getCustomerById(id);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateCustomerForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("customer/create.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> listCustomer = customerService.selectAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/listCustomer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}

