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
@WebServlet("/Delete")
public class Delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Connection con = ConnectDB.Create();
        Connection con;
        ResultSet rs;
        PreparedStatement ps,ps1,ps2;
        Statement st;
        String email=req.getParameter("email1");
        ServletContext context=req.getServletContext();
        //String emailid=" ",name="",phoneno,city,password;
        String name="",emailid="",password="",city="",phoneno="";
        PrintWriter out=resp.getWriter();


        try {
            Class.forName(context.getInitParameter("driver"));
            con = DriverManager.getConnection(context.getInitParameter("url"),
                    context.getInitParameter("username"), context.getInitParameter("password"));
            ps1 = con.prepareStatement("select * from demo where email=?");
            ps1.setString(1,email);
            rs = ps1.executeQuery();

            while (rs.next()){
                emailid=rs.getString(2);
              name = rs.getString(1);
               // email = rs.getString(3);
              password = rs.getString(3);
                city = rs.getString(4);
                phoneno = rs.getString(5);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        try {
           ps2 = con.prepareStatement("insert into afterdelete values(?,?,?,?,?)");

            ps2.setString(1,name);
           ps2.setString(2,email);
         ps2.setString(3,password);
            ps2.setString(4,city);
          ps2.setString(5,phoneno);

          ps2.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try {
            ps = con.prepareStatement("delete from demo where email=?");
            ps.setString(1, email);
            ps.execute();

            out.println("<h1>Deleted Sucessfully!</h1>");
            RequestDispatcher rd = req.getRequestDispatcher("WelcomeAdmin");
            rd.forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
