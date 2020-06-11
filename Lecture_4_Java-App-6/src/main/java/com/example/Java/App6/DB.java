package com.example.Java.App6;

import java.util.*;

public class DB {

    private HashMap<String,String> dataStore;
    private ArrayList<User> userTable;
    private ArrayList<Book> bookTable;

    public DB(){
        dataStore = new HashMap<>();
        dataStore.put("Sachin"," A great Cricketer");
        dataStore.put("gfg","A good website");

        userTable = new ArrayList<>();
        userTable.add(new User(4,"Raka",50));
        userTable.add(new User(6,"Raka",60));
        userTable.add(new User(7,"Saka",70));
        userTable.add(new User(8,"Shakal",80));

        bookTable = new ArrayList<>();
        bookTable.add(new Book(1,"Dalai Lama","Freedom in Exile "));
        bookTable.add(new Book(2,"Raghav Bahal","Super Economies"));
        bookTable.add(new Book(3,"L.k.Advani","My Country My Life "));
        bookTable.add(new Book(4,"Pt Ravi Shankar","My Music My Life "));

    }

    public String searchAWord(String word){
        return dataStore.get(word);
    }

    public List<User> searchUsersByUserName(String name){
        ArrayList<User> list = new ArrayList<>();
        for(User user: userTable){
            if(user.getName().equals(name)) list.add(user);
        }
        return list;
    }
    public User searchAUserByUserId(int id){
        for(User user: userTable){
            if(user.getId()==id) return user;
        }
        return null;
    }

    public boolean addAUser(User user){
        userTable.add(user);
        return true;
    }
    public List<User> getAllUsers(){
        return userTable;
    }

    public boolean deleteAUser(int id){
        for(User user: userTable){
            if(user.getId()==id) {
                userTable.remove(user);
                return true;
            }
        }
        return false;
    }

    public boolean updateAUser(User inputUser){
        for(User user: userTable){
            if(user.getId()==inputUser.getId()) {
                userTable.remove(user);
                userTable.add(inputUser);
                return true;
            }
        }
        return false;
    }

    public List<Book> findAllBooks(){
        return bookTable;
    }

    public boolean addABook(Book book){
        bookTable.add(book);
        return true;
    }

}
