import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/showproduct")
public class ShowProduct extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // CustomerRegister.ShowProduct(req, resp);
        PrintWriter out = resp.getWriter();
        out.println("Hello from Servlet");

        Configuration configuration=new Configuration().configure();
        Session session=configuration.buildSessionFactory().openSession();
        //Session s = FactoryProvider.getSessionFactory().openSession();
        Query q = session.createQuery("from Product");
        List<Customer> list = q.getResultList();
        req.setAttribute("listProduct",list);
        req.getRequestDispatcher("AllProduct.jsp").forward(req,resp);
        session.close();
    }
}