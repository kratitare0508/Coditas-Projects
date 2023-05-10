import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/Update")
public class Update extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       PrintWriter out = resp.getWriter();
Connection con;
        ServletContext context=req.getServletContext();
        resp.setContentType("Text/HTML");

        String email=req.getParameter("email1");
        String emailid="",name="",password="",phoneno="";
        String city="";
        try {

            Class.forName(context.getInitParameter("driver"));
            con = DriverManager.getConnection(context.getInitParameter("url"),
                    context.getInitParameter("username"), context.getInitParameter("password"));
           PreparedStatement ps=con.prepareStatement("select * from demo where email=?");
           ps.setString(1,email);
           ResultSet rs=ps.executeQuery();

           while(rs.next())
           {
                name=rs.getString(1);
                emailid=rs.getString(2);
               password=rs.getString(3);
               city=rs.getString(4);
               phoneno=rs.getString(5);
           }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        out.println("<h2>Student MAIL:"+emailid+"</h2>" +
                "<form action='UpdateDb'>" +
                "NAME: <input type='text' name='nameup' value='"+name+"'>" +
                "EMAIL:<input type='text' name='emailup' value='"+emailid+"'>" +
                "CITY:<input type='text' name='cityup' value='"+city+"'>" +
                "PHONE:<input type='text' name='phoneno' value='"+phoneno+"'>" +
                "<input type='submit' value='UPDATE'>" +
                "</form>");


    }
}

