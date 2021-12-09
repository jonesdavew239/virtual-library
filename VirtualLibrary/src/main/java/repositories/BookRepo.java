/*
 * Team 6 (Amy Osborne, Gabriel Agbo, Tyree McDowell, David Jones)
 * Virtual Library Project
 * C211
 * 12/2/2021
 */
package repositories;

import java.util.ArrayList;
import java.util.List;
import com.teamsix.virtuallibrary.models.Book;

public class BookRepo {

    private ArrayList<Book> _books = new ArrayList<Book>();
    
    public BookRepo(ArrayList<Book> books){
        _books = books;
    }

    public Book Addbook (Book book){
        _books.add(book);
        return book;
    }        

    public Book UpdateBook (Book book){
        Book result = this.GetBook(book.bookId);
        
        if(result != null) {
            int index = _books.indexOf(result);
            _books.set(index, book);
            
            return book; 
        } 
    
        return null;
        
    }
    
    public void DeleteBook (int bookId){
        Book result = this.GetBook(bookId);
        
        if(result == null) return;
        
        int index = _books.indexOf(result);
        _books.remove(result);
    }
    
    public Book GetBook(int bookId){
        for (Book book : _books) {
            if(book.getBookId() == bookId){
                return book;
            }
        } 
        
        return null;
    }    
    
    public ArrayList<Book> GetBooksByTitle(String title){
        ArrayList<Book> books = new ArrayList<Book>();
        
        for (Book book : _books) {
            if(book.bookTitle.contains(title)){
                books.add(book);
            }
        }
        
        return books; 
    }
    
}
