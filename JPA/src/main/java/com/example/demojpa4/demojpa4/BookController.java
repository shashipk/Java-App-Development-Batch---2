package com.example.demojpa4.demojpa4;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @PostMapping("/createBook")
    public void create(@RequestBody Book book){
        bookRepository.saveAll(Collections.singletonList(book));
    }

    // This is hibernate's back end implementation

    // ResultSet rs = sql.executeQuery();
    // while(rs.next()){
    //      String name = rs.getString(2)
    //      Book b = new Book()
    //      b.setName(name);
    //      b.setCost(cost);
    // }

    @GetMapping("/getAllBooks")
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/getBookById")
    public Book getBookById(@RequestParam(value = "id") String id){

        Integer my_id = Integer.parseInt(id);
        Optional<Book>results =  bookRepository.findById(my_id);
        if(results != null){
            return results.get();
        }else{
            return null;
        }
    }
}
