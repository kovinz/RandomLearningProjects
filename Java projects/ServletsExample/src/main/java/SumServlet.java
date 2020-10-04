import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SumServlet extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String[] values = request.getParameterValues("v");
    PrintWriter out = response.getWriter();
    int sum = 0;
    for (String value : values) {
      sum += Integer.parseInt(value);
    }
    out.println("<h1>" + sum + "</h1>");
  }
}
