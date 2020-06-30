package com.example.demojpa4.demojpa4;

import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;

// book_category

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String authorName;

    // author_name

    @Column(name = "price")
    private int cost;

//    public Book(String name, String authorName, int cost) {
//        this.name = name;
//        this.authorName = authorName;
//        this.cost = cost;
//    }

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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
