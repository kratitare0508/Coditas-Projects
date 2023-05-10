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

@WebServlet("/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con;
        PreparedStatement ps;
        Statement st;
        ResultSet rs;

        HttpSession session = req.getSession();

        PrintWriter out = resp.getWriter();
        ServletContext context = req.getServletContext();
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        if (email.equals("admin@123") && pass.equals("admin")) {
            resp.sendRedirect("WelcomeAdmin");
        }
        else
        {
            int count=0;
            try{
                Class.forName(context.getInitParameter("driver"));
                con = DriverManager.getConnection(context.getInitParameter("url"),
                        context.getInitParameter("username"), context.getInitParameter("password"));
                ps = con.prepareStatement("select * from loginauth");
                rs = ps.executeQuery();

                while(rs.next())
                {
                    String username=rs.getString(1);
                    String password=rs.getString(2);

                    if (username.equals(email) && password.equals(pass)) {
                        count++;
                        break;
                    }
                }
                if (count== 1) {

                    String name = "";

                    ps = con.prepareStatement("select firstname,email from demo where email=?");
                    ps.setString(1, email);
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        name = rs.getString(1);
                        //email=rs.getString(2);
                    }

                    session.setAttribute("email", email);
                    session.setAttribute("name",name);
                    resp.sendRedirect("WelcomeStudent");
                }
                else {
                    out.println("<div align='center'><h1>Invalid Credentials!!</h1></div>");
                    RequestDispatcher rd = req.getRequestDispatcher("login.html");
                    rd.include(req, resp);
                }
                } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}