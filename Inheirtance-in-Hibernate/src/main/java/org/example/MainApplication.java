package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApplication {
    public static void main(String[] args) {
        try
        {
            Configuration configuration=new Configuration().configure();
         Session session=configuration.buildSessionFactory().openSession();
            Transaction transaction=session.beginTransaction();
        Employee e1=new Employee(1,"Krati");
        PartTimeEmp e2=new PartTimeEmp(2,"Vibha",500,30);
        FullTimeEmp e3=new FullTimeEmp(3,"Satakshi",25000,12,300);
            session.save(e1);
            session.persist(e1);
            session.save(e2);
            session.persist(e2);
            session.save(e3);
            session.persist(e3);
            transaction.commit();
        session.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
