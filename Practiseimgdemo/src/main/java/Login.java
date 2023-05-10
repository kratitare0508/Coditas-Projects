import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        try {
            Class.forName(context.getInitParameter("driver"));
            Connection con = DriverManager.getConnection(context.getInitParameter("url"),
                    context.getInitParameter("username"), context.getInitParameter("password"));
            PreparedStatement ps = con.prepareStatement("select * from practise1");
            ResultSet rs = ps.executeQuery();
            int count = 0;
            String user = req.getParameter("username");
            String password = req.getParameter("password");
            String name = " ";

            while (rs.next()){
                String username=rs.getString(2);
                String pwd=rs.getString("password");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
