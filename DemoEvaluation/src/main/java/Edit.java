import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/Edit")

public class Edit extends HttpServlet {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
     String email = req.getParameter("email");
       String detail = req.getParameter("detail");
        String update = req.getParameter("update");
        try {
            Class.forName(context.getInitParameter("driver"));
            con = DriverManager.getConnection(context.getInitParameter("url"),
                    context.getInitParameter("username"), context.getInitParameter("password"));
            ps = con.prepareStatement("update demo set " + detail + "= '" + update + "' where email='" + email + "' ");
          ps=con.prepareStatement("select * from demo where email=?");
          ps.setString(1,email);
//         rs=ps.executeQuery();
//         rs.next();
//         req.setAttribute("firstname",rs.getString(1));
//         req.setAttribute("email",rs.getString(2));
//         req.setAttribute("city",rs.getString(4));
//         req.setAttribute("phoneno",rs.getString(5));
            out.println("<h1>Updated Sucessfully!");
            out.println("<h1><a href='WelcomeAdmin'>Back</a></h1>");
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("Delete.html");
            requestDispatcher.include(req,resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
