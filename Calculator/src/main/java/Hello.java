import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int x,y;
		String str="";
		x=Integer.parseInt(request.getParameter("txtfno"));
y=Integer.parseInt(request.getParameter("txtsno"));
str=request.getParameter("operation");
if(str.equals("add"))
	out.println("<h1>Result of addition is:"+(x+y)+"</h1>");
else if(str.equals("sub"))
	out.println("<h1>Result of Subtraction is:"+(x-y)+"</h1>");
else if(str.equals("mul"))
	out.println("<h1>Result of multiplication is:"+(x*y)+"</h1>");
else
	out.println("<h1>Result of Divison is:"+(x/y)+"</h1>");

out.println("<a href=\"index.jsp\">back</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
