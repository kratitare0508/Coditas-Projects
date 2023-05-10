package org.example;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentDao {
    public static Configuration configuration=new Configuration().configure();
   public static  SessionFactory sessionFactory= configuration.buildSessionFactory();

    public static  void insertStudent(Student student)
    {
        Session session= sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        Student student1=new Student();
        session.save(student1);
        transaction.commit();
        session.close();



    }

    public static void updateStudent(Student student) throws IOException {
        boolean flag=false;
        Student student1=new Student();
        System.out.println("Enter what u want to update");
        System.out.println("0. Nothing 1. Name 2. Clg name 3.Address 4.Email");
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        int ch=Integer.parseInt(sc.readLine());
        switch(ch)
        {
            case 0:
                flag=false;
                break;
            case 1:
                Session session1= sessionFactory.openSession();
                Transaction transaction= session1.beginTransaction();
                System.out.println("Enter sid u want to update");
                int studentid=Integer.parseInt(sc.readLine());
                System.out.println("Enter newname");
                String newname=sc.readLine();

                Query query=session1.createQuery("update Student SET studentname=: newname where studentid=: studentid");
                query.setParameter("studentid",studentid);
                query.setParameter("newname",newname);
               // student.setStudentname(newname);

                query.executeUpdate();


                //query.setParameter("studentId", studentId);
                //ession1.save(student);
                transaction.commit();
                //session1.close();


                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }



    }

    public static void fetchallUsers(Student student)
    {
        Session session=configuration.buildSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        List<Student> list=new ArrayList<Student>();
        Query q=session.createQuery("from Student");
       // q.executeUpdate();
        list=q.getResultList();
        Iterator iterator=list.listIterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
         }

    transaction.commit();
        session.close();

    }
    public static void  fetchbyProjections(Student student)
    {
        Session session=configuration.buildSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        Criteria criteria= session.createCriteria(Student.class);

criteria.setProjection(Projections.property("studentname"));
List<String>list=criteria.list();

for(String s:list)
{
    System.out.println(s);
}
transaction.commit();
session.close();

    }

public static void multipleprojection(Student student)
{
    Session session=configuration.buildSessionFactory().openSession();
    Transaction transaction= session.beginTransaction();

    Criteria criteria= session.createCriteria(Student.class);
    ProjectionList p1=Projections.projectionList();




}
public static void FetchDemo(Student student)
{
    Session session= sessionFactory.openSession();

    Student student1=(Student)session.get(Student.class,1);
    System.out.println(student1);
    session.close();


}
}
