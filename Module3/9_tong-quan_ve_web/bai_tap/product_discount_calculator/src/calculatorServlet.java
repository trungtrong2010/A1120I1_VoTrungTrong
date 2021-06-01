import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calculatorServlet", urlPatterns = "/calculatordiscount")
public class calculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        float percent = Float.parseFloat(request.getParameter("percent"));
        float result = price * percent / 100;

//        PrintWriter writer = response.getWriter();
//        writer.println("<html>" +
//                "<h3>Product description: " + description + "</h3>" +
//                "<h3>Chiet khau: " + amount + " $ </h5>" +
//                "</html>");
        request.setAttribute("description", description);
        request.setAttribute("price", price);
        request.setAttribute("percent", percent);
        request.setAttribute("result",result);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien2.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien.jsp");
        dispatcher.forward(request, response);
    }
}
