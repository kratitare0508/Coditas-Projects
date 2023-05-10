import com.mysql.cj.protocol.Resultset;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/UpdateDb")
public class UpdateDb extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con;
        PreparedStatement ps;
        Resultset rs;
        ServletContext context = req.getServletContext();
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("nameup");
        String email = req.getParameter("emailup");
        String city = req.getParameter("cityup");
        String phoneno = req.getParameter("phoneno");

        try {
            Class.forName(context.getInitParameter("driver"));
            con = DriverManager.getConnection(context.getInitParameter("url"),
                    context.getInitParameter("username"), context.getInitParameter("password"));
            ps = con.prepareStatement("update demo set email='" + email + "',firstname='" + name + "',city='" + city + "',phoneno='" + phoneno + "' where email=? ");
            ps.setString(1, email);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher rd = req.getRequestDispatcher("WelcomeAdmin");
        rd.forward(req, resp);
    }
}