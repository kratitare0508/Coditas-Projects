package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
    public static void main(String[] args) {
        Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Question question1=new Question();
        question1.setQuestionId(104);
        question1.setQuestion("What is java?");

        Answer answer=new Answer();

        answer.setAnswerId(1044);
      answer.setAnswer("java is a programming lang");
      answer.setQ(question1);
      question1.setAnswer(answer);
       //session is usd to save obj

        Question question2=new Question();
        question2.setQuestionId(105);
        question2.setQuestion("why is java robust");

        Answer answer2=new Answer();
        answer2.setAnswerId(1055);
        answer2.setAnswer("garbage collector and exception handlling");
        answer2.setQ(question2);
        question2.setAnswer(answer2);

        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(question1);
        session.save(answer);
        session.save(question2);
        session.save(answer2);
        transaction.commit();
        session.close();

        System.out.println(question1.getQuestion());
        System.out.println(answer.getAnswer());
        sessionFactory.close();
    }
}
