
    import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
    import java.io.PrintWriter;

    @WebServlet("/showcustomer")
    public class ShowCustomer extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            CustomerRegister.ShowCustomer(req,resp);

            Customer customer=new Customer();
            PrintWriter out=resp.getWriter();
            out.println("Customername::"+"=="+customer.getCustomername());


        }
    }

