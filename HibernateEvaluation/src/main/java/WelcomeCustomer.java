import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/welcomecustomer")
public class WelcomeCustomer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        out.println("hello customer");
        //admin can see list of customer and perform addupdate delte;
        //crm-edit delete

        //out.println("<a href='register.jsp'>ADD NEW Product</a>");

        //out.println("<a href='customerdeleteservlet'>DELETE CUSTOMER</a>");
        out.println("<a href='showcustomer'>SHOW CUSTOMER</a>");
        out.println("<a href='addproduct.jsp'>ADD PRODUCT</a>");
        out.println("<a href='showproduct'>SHOW PRODUCT</a>");


    }
}
