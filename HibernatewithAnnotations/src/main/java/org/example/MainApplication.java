package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        Book book=new Book();
        while (flag) {
            System.out.println("0 for Exit");
            System.out.println("1.Insert ");
            System.out.println("2.Update");
            System.out.println("3.Delete");
            System.out.println("4.Fetch all records");
            System.out.println("5.Fetch by Restrictions");
            System.out.println("6.Fetch by Order");
            System.out.println("7.Fetch by projection");
            System.out.println("8.Fetch multiple records by projection");
            System.out.println("9.Get backup table of deleted data");
            System.out.println("Enter your choice");
            int ch = Integer.parseInt(sc.readLine());

            switch(ch)
            {
                case 0:
                    flag=false;
                    break;
                case 1:
                    System.out.println("Enter bookid,bookname,authorname,publishername,publisheryear,price");
                    book.setId(Integer.parseInt(sc.readLine()));
                    book.setBookName(sc.readLine());
                    book.setAuthorName(sc.readLine());
                    book.setPublisherName(sc.readLine());
                    book.setPublishedYear(Integer.parseInt(sc.readLine()));
                    book.setPrice(Integer.parseInt(sc.readLine()));
                    BookDao.insertBook(book);
                    System.out.println("Insertion done!");

                    break;
                case 2:
                    System.out.println("Enter bookname that you wanna update");
                    String bookname1=sc.readLine();
                    System.out.println("Enter price to be updated");
                    int p1=Integer.parseInt(sc.readLine());
                    BookDao.Updatebook(bookname1,p1);
                    System.out.println("Updation done");

                    break;
                case 3:

                    BookDao.DeleteUser();
                    System.out.println("Deletion done!!");
                    break;
                case 4:
                    BookDao.fetchAllusers();

                    break;
                case 5:
                    BookDao.fetchbyRestrictions();

                case 6:
                    System.out.println("Enter order(asc/desc)");
                    String order=sc.readLine();
                    System.out.println("Enter property name");
                    String pn=sc.readLine();
                    BookDao.fetchbyOrder(order,pn);

                    break;
                case 7:
                    BookDao.fetchbyProjection();
                    break;
                case 8:
                    BookDao.fetchmultiplebyprojection();
                    break;
                case 9:
                    BookDao.deletedbackup();
                    break;
                default:
                    System.out.println("Inavlid Input");
            }
        }
    }
}
