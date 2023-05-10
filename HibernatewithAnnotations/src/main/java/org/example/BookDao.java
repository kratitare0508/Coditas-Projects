package org.example;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;

import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookDao {

    public static Configuration configuration = new Configuration().configure();
    static SessionFactory sessionFactory = configuration.buildSessionFactory();

    public BookDao(SessionFactory sessionFactory) {
        super();
        this.sessionFactory = sessionFactory;
    }

    public static boolean insertBook(Book book) {
        boolean flag = false;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        int i = (int) session.save(book);
        if (i > 0) {
            flag = true;
        }
        transaction.commit();
        session.close();
        return flag;
    }

    public static int Updatebook(String bookn, int p) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("update Book set  bookName=:bookname1,price=:p1 where id = :id1");


        q.setParameter("bookname1", bookn);
        q.setParameter("p1", p);

        q.setParameter("id1", 5);
        int i = q.executeUpdate();
        transaction.commit();
        return i;
    }

    public static void DeleteUser() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the id of Book which you want to delete");
        int bookid = Integer.parseInt(sc.readLine());

//       // Query q=session.createQuery("DELETE FROM Book " + "WHERE id = : bookid");
//
//        Query q=session.createQuery("from Book where id = :bookid");
//        q.setParameter("bookid",bid);
//        int i= q.executeUpdate();
//        transaction.commit();
//        return i;

        Book book = session.get(Book.class, bookid);
        session.delete(book);
        transaction.commit();
        session.close();
    }


    public static void fetchAllusers()
    {
        Session session= sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        List<Book> books=new ArrayList<Book>();
        Query q=session.createQuery("from Book");
        books=q.getResultList();
        Iterator iterator=books.listIterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        transaction.commit();
        session.close();

    }
    public static void fetchbyRestrictions() throws IOException {
        Session session= sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter price to be apply based on criteria");
       int p=Integer.parseInt(sc.readLine());
        Criteria criteria=session.createCriteria(Book.class);
        criteria.add(Restrictions.gt("price",p));
       List<Book> list=criteria.list();

       for(Book book:list)
       {
           System.out.println(book);
       }


      // list=BookDao.fetchbyRestrictions(p);



    }
    public static  void fetchbyOrder(String order,String pn)
    {
        Session session= sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        Criteria criteria=session.createCriteria(Book.class);
        if(order.equalsIgnoreCase("asc"))
        {
            criteria.addOrder(Order.asc(pn));
        }
        else if(order.equalsIgnoreCase("desc"))
        {
            criteria.addOrder(Order.desc(pn));
        }
        List<Book> list=criteria.list();

        for(Book book:list)
        {
            System.out.println(book);
        }
        //return criteria.list();


    }
    public static void fetchbyProjection() throws IOException {
        Session session= sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        Criteria criteria=session.createCriteria(Book.class);
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter property name");
        String pn=sc.readLine();
        criteria.setProjection(Projections.property(pn));
        List<Object> list = criteria.list();

        for (Object value : list) {
            System.out.println("value: " + value);
        }
       transaction.commit();
        session.close();
//        List<Book> list=criteria.list();
//
//        for(Book book:list)
//        {
//            System.out.println(book);
//        }
      //  Projection projection= Projections.property("id");

        //ProjectionList plist=Projections.projectionList();
        //plist.add(projection);

    }
    public static void fetchmultiplebyprojection() throws IOException {
         Session session= sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the attributes by you want to project(id,name,authorname)");
        String id=sc.readLine();
        //int id=Integer.parseInt(sc.readLine());
        String authorName=sc.readLine();
        String name=sc.readLine();
        Criteria criteria = session.createCriteria(Book.class);

//        criteria.setProjection("bookName",name)
//                .setProperty("id",id);
        ProjectionList p1=Projections.projectionList();
        p1.add(Projections.property("id"));
        p1.add(Projections.property("authorName"));
        p1.add(Projections.property("bookName"));

        criteria.setProjection(p1);

        List list=criteria.list();

        Iterator iterator=list.iterator();

        while(iterator.hasNext())
        {
            Object obj[] = (Object[])iterator.next();
            System.out.println(obj[0]+"--------"+obj[1]+"----"+obj[2]);
        }



        transaction.commit();
        session.close();
    }
    public static void deletedbackup() throws IOException {
        Session session= sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter id to be delete");
        int id=Integer.parseInt(sc.readLine());
        DeletedBook deletedBook=new DeletedBook();

        Book book=session.get(Book.class,id);

        deletedBook.setId(book.getId());
        deletedBook.setBookName(book.getBookName());
        deletedBook.setAuthorName(book.getAuthorName());
        deletedBook.setPublisherName(book.getPublisherName());
        deletedBook.setPublishedYear(book.getPublishedYear());
        deletedBook.setPrice(book.getPrice());
        session.save(deletedBook);
        session.delete(book);
        transaction.commit();
        session.close();

    }
}




