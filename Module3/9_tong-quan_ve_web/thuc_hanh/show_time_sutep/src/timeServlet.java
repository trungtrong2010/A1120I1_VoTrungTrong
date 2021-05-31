import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "timeServlet", urlPatterns = "/showtimeLocal")
public class timeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Date today = new Date();
//        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//        writer.println("<h1>"+today+"</h1>");
//        writer.println("</html>");

        request.setAttribute("time", today);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/time.jsp");
        dispatcher.forward(request,response);
    }
}
