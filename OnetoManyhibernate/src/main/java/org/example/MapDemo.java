package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MapDemo {
    public static void main(String[] args) {
        Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory= configuration.buildSessionFactory();

        Teacher teacher=new Teacher();
        teacher.setTeacherid(101);
        teacher.setTeachername("Aarti");

        Student student1=new Student();
        student1.setStudentid(1 );
        student1.setStudentname("Krati");
        student1.setTeacher(teacher);

        Student student2=new Student();
        student2.setStudentid(2);
        student2.setStudentname("Aryaman");
        student2.setTeacher(teacher);
        List<Student> s=new ArrayList<Student>();
        s.add(student1);
        s.add(student2);

        teacher.setStudent(s);
        Session session=sessionFactory.openSession();
         Transaction transaction= session.beginTransaction();
        session.save(teacher);
        session.save(student1);
        session.save(student2);

        Teacher teacher1=(Teacher)session.get(Teacher.class,101);
        System.out.println(teacher1.getTeachername());

        for(Student s1:teacher1.getStudent())
        {
            System.out.println(s1.getStudentname());
        }

        transaction.commit();
        session.close();
    }
}
