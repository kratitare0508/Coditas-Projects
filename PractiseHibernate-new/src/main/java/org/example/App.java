package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws IOException {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        boolean flag = true;
        while(flag){
            System.out.println("Press 0 for exit ");
            System.out.println("Press 1 for Entering Director and their Movies");
            System.out.println("Press 2 for Delete org.example.Director");
            System.out.println("Press 3 for Delete Movies");
            int ch = Integer.parseInt(bf.readLine());
            switch(ch){

                case 0:
                    flag = false;
                    break;
                case 1:
                    System.out.println("Enter the Name of org.example.Director ");
                    String name = bf.readLine();
                    Director director = new Director();
                    director.setName(name);

                    List<Movie> movie = new ArrayList<Movie>();
                    boolean flags = true;
                    while(flags) {
                        System.out.println("Press 0 or Enter the movies");
                        String movieName = bf.readLine();
                        if (movieName.equals("0")) {
                            flags = false;
                        } else {
                            Movie m1 = new Movie();
                            m1.setName(movieName);
                            m1.setDirector(director);
                            movie.add(m1);

                        }
                    }

                    director.setMovie(movie);
                    DirectorDAO.insert(director);
                    for(Movie m : movie) {
                        MovieDAO.insert(m);
                    }

                    break;














            }
        }
    }
}