import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/Showdeleted")

public class Showdeleted extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        ServletContext context = req.getServletContext();
        PreparedStatement ps;
        ResultSet rs;
        Statement st;
        Connection con;
        String email=req.getParameter("email1");
        try {
            Class.forName(context.getInitParameter("driver"));
            con = DriverManager.getConnection(context.getInitParameter("url"),
                    context.getInitParameter("username"), context.getInitParameter("password"));
            st = con.createStatement();
            rs=st.executeQuery("select * from afterdelete");
            out.println("<table border='solid'>"+
                    "<th>NAME</th>"+
                    "<th>EMAIL</th>"+
                            "<th>CITY</th>"+
                            "<th>PHONE</th>"
                    );
            while(rs.next())
            {
                String emailid=rs.getString(2);
                out.println("<tr><td>"+rs.getString(1)+"</td>");
                out.println("<td>"+rs.getString(2)+"</td>");
                out.println("<td>"+rs.getString(4)+"</td>");
                out.println("<td>"+rs.getString(5)+"</td>");
                out.println("<td><a href='Retrieve?email1="+emailid+"'>Undo</a></td></tr>");
            }
            out.println("</table>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
