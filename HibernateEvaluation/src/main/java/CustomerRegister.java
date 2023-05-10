import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/customerregister")
public class CustomerRegister extends HttpServlet {
public static Configuration configuration=new Configuration().configure();
    public static SessionFactory sessionFactory = configuration.buildSessionFactory();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
              PrintWriter out = resp.getWriter();
            resp.setContentType("text/html");


            String customername = req.getParameter("customername");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
              //Product product=new Product();

              Product product1=new Product("Bangle",10,50,0);

            Customer customer = new Customer();
            customer.setCustomername(customername);
            customer.setEmail(email);
            customer.setPassword(password);
               product1.setCustomer(customer);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        customer.setProducts(products);



        HttpSession se = req.getSession();
        se.setAttribute("customer", customer);


            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            session.save(customer);

            transaction.commit();
            session.close();

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(req, resp);

        }

        public static void ShowCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            List<Customer> listCustomer = new ArrayList<Customer>();

            try {
                Query query = session.createQuery("from Customer");
                listCustomer = query.getResultList();
                transaction.commit();
            }
            catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
            finally {
                session.close();
            }

            request.setAttribute("listCustomer",listCustomer);
            System.out.println(listCustomer);
            request.getRequestDispatcher("showcustomer.jsp").forward(request,response);
        }

        public static void ShowProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            List<Product> listProduct = new ArrayList<Product>();

            try {
                Query query = session.createQuery("from Product");
                listProduct = query.getResultList();
                transaction.commit();
            }
            catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
            finally {
                session.close();
            }

            request.setAttribute("listProduct",listProduct);
            request.getRequestDispatcher("showproduct.jsp").forward(request,response);
       }
    }

