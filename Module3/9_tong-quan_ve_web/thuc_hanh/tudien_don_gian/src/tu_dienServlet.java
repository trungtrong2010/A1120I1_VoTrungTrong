import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "tu_dienServlet", urlPatterns = "/tudiendongian")
public class tu_dienServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dich = new HashMap<>();
        dich.put("hello", "Xin chào");
        dich.put("how", "Thế nào?");
        dich.put("what", "Cái gì?");
        dich.put("book", "Quyển vở");
        dich.put("computer", "Máy tính");

        String search = request.getParameter("search");
        String result = dich.get(search);
        if (result != null) {
            request.setAttribute("result", result);
        } else {
            request.setAttribute("result","Not found");
        }
        request.setAttribute("search", search);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien.jsp");
        dispatcher.forward(request, response);
//        Map<String, String> dictionary = new HashMap<>();
//        dictionary.put("hello", "Xin chào");
//        dictionary.put("how", "Thế nào");
//        dictionary.put("book", "Quyển vở");
//        dictionary.put("computer", "Máy tính");
//
//        String search = request.getParameter("search");
//
//        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//
//        String result = dictionary.get(search);
//        if (result != null) {
//            writer.println("Word: " + search);
//            writer.println("Result: " + result);
//        } else {
//            writer.println("Not found");
//        }
//
//        writer.println("</html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien.jsp");
        dispatcher.forward(request, response);
    }
}
