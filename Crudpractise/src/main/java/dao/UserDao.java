package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDao {
    public static Configuration configuration = new Configuration().configure();
    static SessionFactory sessionFactory = configuration.buildSessionFactory();



    public UserDao(SessionFactory sessionFactory)
    {
        super();
        this.sessionFactory = sessionFactory;
    }


    public void saveUser(User user)
    {
        Session session=configuration.buildSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        session.save(user);
        transaction.commit();
        session.close();

    }

}
