package com.example.Java.App6;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class DB {

    private HashMap<String,String> dataStore;
    private ArrayList<User> userTable;

    public DB(){
        dataStore = new HashMap<>();
        dataStore.put("Sachin"," A great Cricketer");
        dataStore.put("gfg","A good website");

        userTable = new ArrayList<>();
        userTable.add(new User(4,"Raka",50));
        userTable.add(new User(6,"Raka",60));
        userTable.add(new User(7,"Saka",70));
        userTable.add(new User(8,"Shakal",80));
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

}
