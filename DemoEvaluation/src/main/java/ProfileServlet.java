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

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
Connection con;
PreparedStatement ps;
ResultSet rs;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        ServletContext context= req.getServletContext();
        HttpSession session = req.getSession();
        String name  = (String) session.getAttribute("name");
        String email  = (String) session.getAttribute("email");

        try {
            Class.forName(context.getInitParameter("driver"));
            con = DriverManager.getConnection(context.getInitParameter("url"),
                    context.getInitParameter("username"), context.getInitParameter("password"));
            ps = con.prepareStatement("select * from demo where firstname=? and email=?");
            ps.setString(1,name);
            ps.setString(2,email);
            rs =  ps.executeQuery();

            while (rs.next()){

                out.println("<div align='center'><h1>Name:"+rs.getString(1)+"</h1>");
                out.println("<div align='center'><h1>Email:"+rs.getString(2)+"</h1>");
                out.println("<div align='center'><h1>City:"+rs.getString(4)+"</h1>");
                out.println("<div align='center'><h1>Phone:"+rs.getString(5)+"</h1></div>");
            }

            out.println("<h1><a href='WelcomeStudent'>Back</a></h1>");




        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}