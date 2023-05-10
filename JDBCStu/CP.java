package JDBCStu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CP {
   Connection con;

    public void createcon() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc,Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eltp_jan_23", "root", "Jaishreeram@05");


    }

}
