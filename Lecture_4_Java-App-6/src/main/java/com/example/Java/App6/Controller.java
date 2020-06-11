package com.example.Java.App6;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    DB db = new DB();

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/hi")
    public String sayHello(){
        return "Hello Geeks";
    }

    // https://www.google.com/search?q=sachin

    @GetMapping("/search")
    public String search(@RequestParam String q){

        return db.searchAWord(q);
    }

    @GetMapping("/users/all")
    public List<User> findAllUsers(){
        return db.getAllUsers();

    }

    // https://localhost:8080/users?name=Ramu
    // http://localhost:8080/users/4
    @GetMapping("/users")
    public List<User> findAllUsers(@RequestParam String name){
       return db.searchUsersByUserName(name);
    }

    @PostMapping("/users")
    public boolean createANewUser(@RequestBody User user){
        return db.addAUser(user);
    }

    // https://localhost:8080/users?id=4   -->query param
    // http://localhost:8080/users/4      ----> path param

    @GetMapping("/users/{id}")
    public User findAUser(@PathVariable int id ){
        return db.searchAUserByUserId(id);
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteAUser(@PathVariable int id){

        return db.deleteAUser(id);
    }

    // put == updating
    @ApiOperation("It updates the user deatils")
    @PutMapping("/users")
    public boolean updateAUser(@RequestBody User user){
        return db.updateAUser(user);
    }

    /*
    Post API for Book :
    Validate the request ( Book )
    title
    author

     */

}
