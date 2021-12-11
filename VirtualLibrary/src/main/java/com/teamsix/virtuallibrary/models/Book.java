/*
 * Team 6 (Amy Osborne, Gabriel Agbo, Tyree McDowell, David Jones)
 * Virtual Library Project
 * C211
 * 12/2/2021
 */
package com.teamsix.virtuallibrary.models;

import java.util.Date; 
import java.util.Scanner;

public class Book {
    
    Scanner input = new Scanner(System.in);
    
    public int bookId;
    public int libraryId;
    public int iSBN;
    public String bookTitle;
    public String bookAuthor;
    public int yearPublished; 
    public Boolean isFiction;

    public Book (int bookId){
        this.bookId = bookId;
        this.libraryId = 1;
        
        System.out.println("Enter book title:");
        this.bookTitle = input.next();
        
        System.out.println("Enter book author:");
        this.bookAuthor = input.next();
        
        System.out.println("Enter book isbn (as a number):");
        this.iSBN = input.nextInt();
        
        System.out.println("Enter book published year:");
        this.yearPublished = input.nextInt();
        
        System.out.println("Is this book fiction? yes or no:");
        String result = input.next();
        if(result == "yes"){
            this.isFiction = true;
        } else {
            this.isFiction = false;
        }
    }   
    
    public Book (int bookId, int libraryId, int iSBN, String bookTitle, 
            String bookAuthor, int yearPublished, Boolean isFiction){
    
        this.bookId = bookId;
        this.libraryId = libraryId;
        this.iSBN = iSBN;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor; 
        this.yearPublished = yearPublished;
        this.isFiction = isFiction;
    }
    
    public int getBookId () {
        return this.bookId;
    }
   
    public void setBookId (int bookId) {
        this.bookId = bookId;
    }
    
    public int getLibraryId () {
        return this.libraryId;
    }
   
    public void setLibraryId (int libraryId) {
        this.libraryId = libraryId;
    }
    
    public int getISBN () {
        return this.iSBN;
    }
   
    public void setISBN (int iSBN) {
        this.iSBN = iSBN;
    }
    
    public String getBookAuthor () {
        return this.bookAuthor; 
    }
    
    public void setBookAuthor (String bookAuthor) {
        this.bookAuthor = bookAuthor; 
    }
    
    public String getBookTitle () {
        return this.bookTitle; 
    }
    
    public void setBookTitle (String bookTitle) {
        this.bookTitle = bookTitle; 
    }
    
    public boolean getIsFiction () {
        return this.isFiction;
    }
   
    public void setIsFiction (boolean isFiction) {
        this.isFiction = isFiction;
    } 
    
    public void setYearPublished(int year) {
        this.yearPublished = year;
    }
}
    