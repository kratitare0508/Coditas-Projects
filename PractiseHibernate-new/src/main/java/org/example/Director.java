package org.example;


import javax.persistence.*;
import java.util.List;

@Entity
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "director")
    private List<Movie> movie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovie() {
        return movie;
    }

    public void setMovie(List<Movie> movie) {
        this.movie = movie;
    }

    public Director(String name, List<Movie> movie) {
        this.name = name;
        this.movie = movie;
    }

    public Director(String name) {
        this.name = name;
    }

    public Director() {

    }
}
