package com.example.Java.App6;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    DB db = new DB();

    @GetMapping("/books")
    public List<Book> findAllBooks(){
        return db.findAllBooks();
    }

    @PostMapping("/books")
    public boolean createABook(@RequestBody Book book){
        if(BookValidator.isValid(book))
        return db.addABook(book);
        else return false;

    }

    /*

     */

    /*
    Post API for Book :
    Validate the request ( Book )
    title
    author: empty / null

     */
}


