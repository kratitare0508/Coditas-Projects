package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovieDAO {


    public static Configuration configuration = new Configuration().configure();
    public static SessionFactory sessionFactory = configuration.buildSessionFactory();
static BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
    public static void insert(Movie movie){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(movie);
        //session.save()
        transaction.commit();
        session.close();
    }


    public static void update() throws IOException {
        Session session=configuration.buildSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        try {
            System.out.println("Enter new movie name:");
            String newMovieName = sc.readLine();

            Query query = session.createQuery("update Movie set name=:newMovieName where id=:id");
            query.setParameter("newMovieName", newMovieName);
            query.setParameter("id", 1);
            query.executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

}
