package  org.example;

import org.hibernate.annotations.Columns;

import javax.persistence.*;

@Entity
@Table(name="newbook")
public class Book{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)   //autoincrement
    @Column(name="book_id")
    private int id;
//    @Columns(columns = {
//            @Column(name = "book_name"),
//            @Column(name = "author_name"),
//            @Column(name="publisher_name"),
//    })

    @Column(name="book_name")
    private String bookName;

    @Column(name="author_name")
    private String authorName;
    @Column(name="publisher_name")
    private String publisherName;
//@Columns(columns={
//        @Column(name="published_year"),
//        @Column(name="book_price")
//})
    @Column(name="published_year")

    private int publishedYear;
    @Column(name="book_price")
    private int price;

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", publisherName='" + publisherName + '\'' +
                ", publishedYear=" + publishedYear +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}