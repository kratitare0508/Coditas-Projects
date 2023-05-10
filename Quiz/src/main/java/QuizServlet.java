import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Enumeration;

@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        String paramName,paramValue[];
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        int cnt=0;
        String ans="";
        Enumeration paramNames=req.getParameterNames();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/practisekt","root","Jaishreeram@05");
            st=con.createStatement();
            rs=st.executeQuery("select * from quiz");
        while(rs.next() && paramNames.hasMoreElements())
        {
            String un=rs.getString(2);
            paramName=(String)paramNames.nextElement();
            paramValue=req.getParameterValues(paramName);
            System.out.println(paramValue);
            for(int i=0;i<paramValue.length;i++)
            {
                ans=paramValue[i];
            }
            if(un.equals(ans))
            {
                cnt++;
            }

        }
            out.println("You have scored"+cnt+"points");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
