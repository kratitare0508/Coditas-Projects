import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name=req.getParameter("name");
       String email=req.getParameter("email");
       String password=req.getParameter("password");
       String image=req.getParameter("image");
       Part file=req.getPart("image");
       String imageFileName=file.getSubmittedFileName();
       String uploadPath="C:/Users/coditas/IdeaProjects/Practiseimgdemo/src/main/webapp/Images/"+imageFileName;

        FileOutputStream fos=new FileOutputStream(uploadPath);
        InputStream in=file.getInputStream();
        byte[] data=new byte[in.available()];
        in.read(data);
        fos.write(data);
        fos.close();
        ServletContext context=getServletContext();
        PrintWriter out=resp.getWriter();
        try {
            Class.forName(context.getInitParameter("driver"));
            Connection con = DriverManager.getConnection(context.getInitParameter("url"),
                    context.getInitParameter("username"), context.getInitParameter("password"));
            PreparedStatement ps=con.prepareStatement("insert into practise1 values(?,?,?,?)");
            ps.setString(1,name);
            ps.setString(2,email);
            ps.setString(3,password);
            ps.setString(4,imageFileName);
  ps.executeUpdate();
  out.println("Registered");
            RequestDispatcher rd= req.getRequestDispatcher("index.html");
            rd.include(req,resp);
            resp.sendRedirect("login.html");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
