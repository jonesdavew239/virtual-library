/*
 * Team 6 (Amy Osborne, Gabriel Agbo, Tyree McDowell, David Jones)
 * Virtual Library Project
 * C211
 * 12/2/2021
 */
package Repositories;

import java.util.ArrayList;
import java.util.Scanner;
import com.teamsix.virtuallibrary.models.Book;

public class BookRepo {
    
    private ArrayList<Book> _books = new ArrayList<Book>();
    Scanner input = new Scanner(System.in);
    
    public BookRepo(ArrayList<Book> books){
        _books = books;
    } 
    
    public Book AddBook(){
        Book book = new Book(_books.size() + 1);
        return AddBook(book);
    }
    
    public Book AddBook(Book book){
        Book result = this.GetBook(book.bookId);
        
        if(result != null){
            System.out.println("Book already exists with book id " + book.bookId);
            return null;
        }
        
        _books.add(book);
        System.out.println("Book added.");
        return book;
    }
    
    public Book UpdateBook(){
        System.out.println("Enter a book id to update.");
        int bookId = input.nextInt();
        Book result = this.GetBook(bookId);

        if(result != null) {
            System.out.println("Enter a title");
            String title = input.next();
            result.setBookTitle(title);

            System.out.println("Enter a author");
            String author = input.next();
            result.setBookAuthor(author);

            System.out.println("Enter a isbn (as a number)");
            int isbn = input.nextInt();
            result.setISBN(isbn);

            System.out.println("Enter year published");
            int yearPublished = input.nextInt();
            result.setYearPublished(yearPublished);

            return this.UpdateBook(result);                        
        }
        
        return null;
    }
    
    public Book UpdateBook(Book book){
        Book result = this.GetBook(book.bookId);
        
        if(result != null){
            
            int index = _books.indexOf(result);
            _books.set(index, book);        

            System.out.println("Book updated.");
            return book;   
        }
        return null;
    }
    
    public void DeleteBook(){
        System.out.println("Enter a book id to delete.");
        int bookId = input.nextInt();
        this.DeleteBook(bookId);
    }
    
    public void DeleteBook(int bookId){
        Book result = this.GetBook(bookId);
        
        if(result == null) return;
        
        int index = _books.indexOf(result);
        _books.remove(result);
        System.out.println("Book deleted.");
    }
    
    public Book GetBook(int bookId){
        for(Book book : _books){
            if(book.getBookId() == bookId){
                return book;
            }
        }
        System.out.println("Book not found.");
        return null;
    }
    
    public ArrayList<Book> GetBooksByTitle(String title){
        ArrayList<Book> books = new ArrayList<Book>();
        
        for(Book book : _books){
            if(book.bookTitle.contains(title)){
                books.add(book);
            }
        }
        
        return books;
    }
    
    public void ListBooks(){
        for(Book book : _books){
            System.out.println("Id: " + book.bookId + ", Title: " + book.bookTitle);
        }
    }
}
