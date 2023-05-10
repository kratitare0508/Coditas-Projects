package SIMCompany;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Random;

public class Operations {

    //table user
    Connection con;
     Statement st;
    PreparedStatement ps;
    ResultSet rs;
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

    public void newConnection() throws IOException, SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eltp_jan_23", "root", "Jaishreeram@05");
//sou
        System.out.println("Enter id");
        int id=Integer.parseInt(sc.readLine());
        System.out.println("Enter name:");
        String name = sc.readLine();
        System.out.println("Enter email:");
        String email = sc.readLine();
        System.out.println("Enter address");
        String address = sc.readLine();
        System.out.println("Enter aadharno");
        int aadharno=Integer.parseInt(sc.readLine());
        System.out.println("Enter simtype:");
        String simtype = sc.readLine();
        System.out.println("Enter initial balance");
        int balance = Integer.parseInt(sc.readLine());
        System.out.println("Enter validity:");
        int validity=Integer.parseInt(sc.readLine());
        int mobileno = 0;
        Random random = new Random();
        mobileno += random.nextInt(900000000) + 1000000000;

        System.out.println("mobile number is:" + mobileno);
 ps= con.prepareStatement("insert into user (id,name,email,address,aadhar,simtype,mobile) values("+id+",'"+name+"','"+email+"','"+address+"','"+aadharno+"','"+simtype+"',"+mobileno+")");
       //ps = con.prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?");

        //rs = ps.executeQuery();
      //  String sql = "insert into user (name,email,address,aadhar,simtype,mobile) values('"+name+"','"+email+"','"+address+"','"+aadharno+"','"+simtype+"','"+mobileno+"')";
       ps.execute();
        System.out.println("insertion successful!");
    }


    public void prepaid() throws SQLException, ClassNotFoundException, IOException, UserDoesNotExistException, RechargeAmountTooLowException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eltp_jan_23", "root", "Jaishreeram@05");
        boolean flag = true;
        System.out.println("Enter mobile number");
        int mobileno=Integer.parseInt(sc.readLine());

        while (true) {
            System.out.println("0 to exit");
            System.out.println("1 to check bal and val");
            System.out.println("2 to recharge");
            System.out.println("Enter your choice:");
            int ch = Integer.parseInt(sc.readLine());
            switch (ch) {
                case 0:
                flag=false;
                    break;
                case 1:
                    st=con.createStatement();
                    String sql="select * from user where mobile="+mobileno+"";
                    ResultSet rs= st.executeQuery(sql);
                    if(rs.next()){
                        System.out.println(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getInt(7)+" "+rs.getInt(8)+" "+rs.getInt(9));
                    }
else
                    {
                        throw  new UserDoesNotExistException();
                    }
                    break;
                case 2:
                    String sqls ="select * from connection where mobile ="+mobileno+" ";
                    ResultSet rset = st.executeQuery(sqls);

                    if(rset.next()){
                        System.out.println("Enter the amount ");
                        int amt = Integer.parseInt(sc.readLine());
                        if(amt<=0){
                            throw new RechargeAmountTooLowException();
                        }else {
                            int balan = rset.getInt(7);
                            balan = balan + amt;

                            String updsql = "update user set balance = " + balan + " , validity = validity +1 where mobile = " + mobileno + " ";
//
                            ps.executeUpdate(updsql);
                            System.out.println("Done");
                        }
                    }
                    else{
                        throw new UserDoesNotExistException();
                    }
                    break;
                default:
                    System.out.println("Enter valid choice");

            }
        }

    }

    public void display() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eltp_jan_23","root","Jaishreeram@05");
           st = con.createStatement();
            String sql = "select * from user order by name";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getInt(7)+" "+rs.getInt(8)+" "+rs.getInt(9));

            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}



