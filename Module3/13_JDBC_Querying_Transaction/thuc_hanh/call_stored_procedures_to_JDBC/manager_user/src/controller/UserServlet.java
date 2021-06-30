package controller;

import model.User;
import service.UserService;
import service.UserServiceImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"/user", ""})
public class UserServlet extends javax.servlet.http.HttpServlet {

    private UserService service = new UserServiceImpl();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createUser(request, response);
                break;
            case "edit":
                updateUser(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            case "findCountry":
                findCountry(request, response);
                break;
            case "a":
                getUsetFindId(request, response);
                break;
            default:
                showUserList(request, response);
                break;
        }
    }

    private void addUserPermision(HttpServletRequest request, HttpServletResponse response) {
        User user = new User("kien", "kienhoang@gmail.com", "vn");
        int[] permision = {1,2,4};
        service.addUserTransaction(user,permision);
    }

    private void getUsetFindId(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = service.findId(id);
        RequestDispatcher dispatcher;
        if (user == null) {
            request.setAttribute("error","Not find User to ID");
        } else {
            request.setAttribute("user", user);
        }
        request.setAttribute("id", id);
        dispatcher = request.getRequestDispatcher("user/user_by_id.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void findCountry(HttpServletRequest request, HttpServletResponse response) {
        String country = request.getParameter("country");
        List<User> listUser = service.findByCountry(country);
        RequestDispatcher dispatcher;
        if (listUser.size() == 0) {
            request.setAttribute("error", "Not find User country");
        } else {
            request.setAttribute("listUser", listUser);
        }
        dispatcher = request.getRequestDispatcher("user/findCountry.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = service.findId(id);
        if (user == null) {
            try {
                response.sendRedirect("user/error.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            service.delete(id);
            try {
                response.sendRedirect("user");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name, email, country);
        System.out.println(user);
        service.update(id, user);
        showUserList(request, response);
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name, email, country);
        service.save(user);

        showUserList(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "findCountry":
                showFindCountryForm(request, response);
                break;
            case "sortName":
                showListSortName(request, response);
                break;
            case "getUserById":
                showUserById(request, response);
                break;
            case "permision":
                addUserPermision(request, response);
                break;
            default:
                showUserList(request, response);
                break;
        }
    }

    private void showUserById(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("user/user_by_id.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListSortName(HttpServletRequest request, HttpServletResponse response) {
        List<User> listSortName = service.sortName();
        request.setAttribute("listSortName", listSortName);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/listSortName.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showFindCountryForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("user/findCountry.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = service.findId(id);
        RequestDispatcher dispatcher;
        if (user == null) {
            dispatcher = request.getRequestDispatcher("user/error.jsp");
        } else {
            request.setAttribute("user", user);
            dispatcher = request.getRequestDispatcher("user/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        User user = service.findId(id);
        RequestDispatcher dispatcher;
        if (user == null) {
            dispatcher = request.getRequestDispatcher("user/error.jsp");
        } else {
            request.setAttribute("user", user);
            dispatcher = request.getRequestDispatcher("user/edit.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("/user/create.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showUserList(HttpServletRequest request, HttpServletResponse response) {

        List<User> listUser = service.findAll();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
