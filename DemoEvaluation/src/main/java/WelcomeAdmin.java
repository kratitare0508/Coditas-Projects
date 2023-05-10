import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/WelcomeAdmin")

public class WelcomeAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con;
        PreparedStatement ps,ps1,ps2;
        Statement st,st2;
        ResultSet rs,rs1,rs2;
        ServletContext context = req.getServletContext();
     PrintWriter out=resp.getWriter();
     resp.setContentType("text/html");
        try {
            Class.forName(context.getInitParameter("driver"));
            con = DriverManager.getConnection(context.getInitParameter("url"),
                    context.getInitParameter("username"), context.getInitParameter("password"));
            st = con.createStatement();
            st2 = con.createStatement();
            rs = st.executeQuery("select * from demo");
            rs2 = st2.executeQuery("select count(*) from demo");

            while(rs2.next()) {
                out.println("<h2>Total Students:" + rs2.getString(1) + "</h2>");
            }
             //String email=rs.getString(2);
               out.println("<table border='solid'><tr>"+
                       "<th>NAME</th>"+
                       "<th>EMAIL</th>"+
                       "<th>CITY</th>"+
                       "<th>PHONE</th>" +
                       "<th>Edit</th>" +
                       "<th>Delete</th></tr>");
            while (rs.next()){
                String email=rs.getString(2);
                out.println("<tr><td>"+rs.getString(1)+"</td>");
                out.println("<td>"+rs.getString(2)+"</td>");
                out.println("<td>"+rs.getString(4)+"</td>");
                out.println("<td>"+rs.getString(5)+"</td>");
                out.println("<td><a href='Update?email1="+email+"'>Update</a></td>");
                out.println("<td><a href='Delete?email1="+email+"'>Delete</a></td></tr>");
                //td>"+rs.getString(6)+"</td></tr>");
            }

            out.println("</table>");
            out.println("<h1><a href='login.html'><button>Logout</button></a></h1><br>");
            out.println("<a href='Edit.html'><button>Edit</button></a>");
            out.println("<a href='Delete.html'><button>Delete</button></a>");
            out.println("<a href='index.html'><button>Add</button></a>");
            out.println("<a href='Showdeleted'><button>Show Deleted Records</button></a>");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}