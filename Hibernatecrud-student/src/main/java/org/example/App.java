package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student=new Student();
        boolean flag=true;
        BufferedReader sc= new BufferedReader(new InputStreamReader(System.in));


        while (flag) {
            System.out.println("Press 0 for exit ");
            System.out.println("Press 1 Insert ");
            System.out.println("Press 2 Update");
            System.out.println("Press 3  fetch all users ");
            System.out.println("4.Projection");
            System.out.println("5.Restriction");
            System.out.println("6 Criteria");
            int ch = Integer.parseInt(sc.readLine());
            switch (ch) {

                case 0:
                    flag = false;
                    break;
                case 1:

                    System.out.println("Enter student name,college,address,mail");
                    student.setStudentname(sc.readLine());
                    student.setCollegename(sc.readLine());
                    student.setAddress(sc.readLine());
                    student.setEmail(sc.readLine());
                    session.save(student);


                    transaction.commit();
                    session.close();


//              List<Student> list= session.createQuery("from student",Student.class).list();
//               for(Student s:list)
//               {
//                   System.out.println(s);
//               }
                    break;
                case 2:
                    Session session1=sessionFactory.openSession();
                    Transaction transaction1= session1.beginTransaction();

                    StudentDao.updateStudent(student);


                    break;
                case 3:
                 StudentDao.fetchallUsers(student);
                   break;
                case 4:
                    StudentDao.fetchbyProjections(student);
                    break;
                case 5:
                    StudentDao.FetchDemo(student);
            }
        }
    }
}