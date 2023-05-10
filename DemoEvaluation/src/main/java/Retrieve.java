import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/Retrieve")

public class Retrieve extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PreparedStatement ps, ps1;
        Connection con;
        ResultSet rs, rs1;
        String email = req.getParameter("email1");
        String name = "", password = "", phoneno = "";
        String city = "";
        ServletContext context = req.getServletContext();
        try {
            Class.forName(context.getInitParameter("driver"));
            con = DriverManager.getConnection(context.getInitParameter("url"),
                    context.getInitParameter("username"), context.getInitParameter("password"));
            String emailid = req.getParameter("email1");
            ps = con.prepareStatement("select * from afterdelete where email='"+emailid+"'");
            rs = ps.executeQuery();
            while(rs.next()) {

                name = rs.getString(1);
                email = rs.getString(2);
                password = rs.getString(3);
                city = rs.getString(4);
                phoneno = rs.getString(5);
                System.out.println(name);
                System.out.println(city);

            }
            ps1 = con.prepareStatement("insert into demo values(?,?,?,?,?)");
            ps1.setString(1, name);
            ps1.setString(2, email);
            ps1.setString(3, password);
            ps1.setString(4, city);
            ps1.setString(5, phoneno);
            ps1.executeUpdate();
            RequestDispatcher rd = req.getRequestDispatcher("WelcomeAdmin");
            rd.forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
