package com.example.Java.App6;

public class BookValidator {

    public static boolean isValid(Book book){
        if(book.getAuthor()==null || book.getAuthor().isEmpty())
            return false;
        return true;
    }
}
