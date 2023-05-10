import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");//img/vdo
        PrintWriter out=resp.getWriter();
        String uname=req.getParameter("uname");
        String pwd=req.getParameter("pwd");
        out.println("WELCOME::"+uname);
        if(uname.equals("pwd"))
            req.getParameter("uname");

    }
}
