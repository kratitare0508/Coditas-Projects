package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();

        //Bizlogic
        Book book=new Book();
        //book.setId(101);
        book.setBookName("The 5 am club");
        book.setAuthorName("Robin Sharma");
        book.setPublisherName("Star publication");
        book.setPublishedYear(2002);
        book.setPrice(1500);
        session.save(book);
        transaction.commit();
        session.close();
        System.out.println(book);


    }
}
