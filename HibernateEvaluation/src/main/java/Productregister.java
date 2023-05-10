//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import static java.lang.System.out;
//
//@WebServlet("/productregister")
//public class Productregister extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        Configuration configuration = new Configuration().configure();
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//      // Customer customer=new Customer();
//
//
//
//        HttpSession session1 = req.getSession();
//
//        int idCus = (int) session1.getAttribute("cid");
//
//        out.println(idCus);
//
//        String name = req.getParameter("productname");
//        int price = Integer.parseInt(req.getParameter("price"));
//        int quantity = Integer.parseInt(req.getParameter("quantity"));
//
//        int totalbill = price*quantity;
//
//        Product product = new Product();
//        product.setProductname(name);
//        product.setPrice(price);
//        product.setAvailibility(availibility);
//       product.setTotalbill(totalbill);
//
//        List<Product> list= new ArrayList<>();
//        list.add(product);
//
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//
//        Customer customer = session.get(Customer.class,idCus);
//        customer.setProducts(list);
//
//        product.setCustomer(customer);
//
//        session.save(product);
//        session.save(customer);
//
//        transaction.commit();
//        session.close();
//
//        resp.sendRedirect("welcomecustomer");
//        out.println("product registred");
//
//    }
//}