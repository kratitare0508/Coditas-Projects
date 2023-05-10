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
        SessionFactory sessionFactory=configuration.buildSessionFactory();

        Employee employee1=new Employee();
        Employee employee2=new Employee();

        employee1.setEmpid(101);
        employee1.setEmployeename("Krati");

        employee2.setEmpid(102);
        employee2.setEmployeename("Shreya");

        Project p1=new Project();
        Project p2=new Project();

        p1.setPid(1011);
        p1.setProjectname("Zomato App");
        p2.setPid(1022);
        p2.setProjectname("Ola App");

       List<Employee> list1=new
               ArrayList<Employee>();
        List<Project> list2=new ArrayList<Project>();

        list1.add(employee1);
        list1.add(employee2);
        list2.add(p1);
        list2.add(p2);

        employee1.setProjects(list2);
        p2.setEmps(list1);

        Session session=sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();

        session.save(employee1);
        session.save(employee2);
        session.save(p1);
        session.save(p2);


        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
