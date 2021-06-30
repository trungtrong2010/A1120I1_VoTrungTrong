package controller;

import model.Student;
import service.StudentService;
import service.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentServlet", urlPatterns = {"/student",""})
public class StudentServlet extends HttpServlet {

    private StudentService service = new StudentServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action"); //create edit delete

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                //tra from tao moi..
                createStudent(request, response);
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                showStudentList(request, response);
        }
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int gender = Integer.parseInt(request.getParameter("gender"));
        int point = Integer.parseInt(request.getParameter("point"));
        String image = request.getParameter("image");

        Student student = new Student(name, gender, point, image);
        service.save(student);

        showStudentList(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action"); //create edit delete

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                //tra from tao moi..
                showCreateForm(request, response);
                break;
            case "edit":
                break;
            case "delete":
                String id = request.getParameter("id");
                System.out.println("id chuan bi xoa la: " + id);
//                service.remove(Integer.parseInt(id));
                showStudentList(request, response);
                break;
            default:
                showStudentList(request, response);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/student/create.jsp");
    }

    private void showStudentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //b1 set data attribute
        request.setAttribute("studentListKey", service.findAll());

        //b2 thuc hien foward
        RequestDispatcher dispatcher = request.getRequestDispatcher("/student/list.jsp");
        dispatcher.forward(request, response);
    }
}
