import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//mysql> create table demo(firstname varchar(20),email varchar(20),password varchar(20),city varchar(20),phoneno varchar(10));
//Query OK, 0 rows affected (0.10 sec)
//
//mysql> create table loginauth(email varchar(20),password varchar(20));
//Query OK, 0 rows affected (0.08 sec)
@WebServlet("/hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ServletContext context = request.getServletContext();
		Connection con;
		PreparedStatement ps,ps1;
		ResultSet rs;
		String firstname=request.getParameter("firstname");
		String email= request.getParameter("email");
		String password= request.getParameter("password");
		String city= request.getParameter("city");
		String phoneno=request.getParameter("phoneno");
        response.setContentType("text/html");
		try {
			Class.forName(context.getInitParameter("driver"));
			con = DriverManager.getConnection(context.getInitParameter("url"),
					context.getInitParameter("username"), context.getInitParameter("password"));
            ps=con.prepareStatement("insert into demo values(?,?,?,?,?)");
			ps1=con.prepareStatement("insert into loginauth values(?,?)");
			ps.setString(1,firstname);
			ps.setString(2,email);
			ps.setString(3,password);
			ps.setString(4,city);
			ps.setString(5,phoneno);


			ps1.setString(1,email);
			ps1.setString(2,password);
			ps.executeUpdate();
			ps1.executeUpdate();

			out.println("<h1>Registered Successfully</h1>");
			out.println("<h1><a href='login.html'>Login</a></h1>");
			RequestDispatcher requestDispatcher= request.getRequestDispatcher("index.html");
			requestDispatcher.include(request,response);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}