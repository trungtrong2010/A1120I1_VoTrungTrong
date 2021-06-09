import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "calculatorServlet", urlPatterns = "/giaodien")
public class calculatorServlet extends HttpServlet {
    public float calculator(float first, char operator, float second) {
        switch (operator) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '/':
                if (second != 0) {
                    return first / second;
                } else {
                    throw new RuntimeException("Second Operator not value '0'");
                }
            default:
                throw new RuntimeException("Not find Operator");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float first = 0;
        float second = 0;
        float calculator = 0;
        String error = null;
        char operator = request.getParameter("operator").charAt(0);
        if (!request.getParameter("first").equals("") && !request.getParameter("second").equals("")) {
            first = Float.parseFloat(request.getParameter("first"));
            second = Float.parseFloat(request.getParameter("second"));
            try {
                calculator = calculator(first, operator, second);
            } catch (RuntimeException e) {
                error = e.getMessage();
            }

            request.setAttribute("result", calculator);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien.jsp");
            dispatcher.forward(request, response);
        } else {
            error = "Value First/Second operator not null";
            request.setAttribute("error",error);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
