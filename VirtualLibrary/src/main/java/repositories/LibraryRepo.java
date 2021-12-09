/*
 * Team 6 (Amy Osborne, Gabriel Agbo, Tyree McDowell, David Jones)
 * Virtual Library Project
 * C211
 * 12/2/2021
 */
package repositories;

import com.teamsix.virtuallibrary.models.Book;
import com.teamsix.virtuallibrary.models.Member;
import java.util.ArrayList;


public class LibraryRepo {
    private BookRepo _bookRepo;
    private MemberRepo _memberRepo;
    private ArrayList<Book> _checkedOutBooks = new ArrayList<Book>();
    
    public LibraryRepo(BookRepo bookRepo, MemberRepo memberRepo){
        _bookRepo = bookRepo;
        _memberRepo = memberRepo;
    }
    
    public String CheckOutBook(Book book){
        Book result = _bookRepo.GetBook(book.bookId);
        
        if(result == null) return "Book not found.";
        
        for (Book checkOutBook : _checkedOutBooks){
            if(checkOutBook.getBookId() == result.bookId){
                return "Book already checked out.";
            }
        }
        
        _checkedOutBooks.add(book);
        
        return "Book titled " + book.bookTitle + " successfully checked out! Enjoy";
    }
    
    public String ReturnBook(Book book){
        Book result = _bookRepo.GetBook(book.bookId);
        
        if(result == null) return "Book not found.";
        
        for(Book checkOutBook : _checkedOutBooks){
            if(checkOutBook.getBookId() == result.bookId){
                _checkedOutBooks.remove(result);
                return "Book titled " + result.bookTitle + " successfully been returned! Thanks!";
            }
        }
        
        return "Book titled " + result.bookTitle + " doesn't appear to be checked out.";
    }    
    
    public ArrayList<Book> SearchBooks(String title){
        return _bookRepo.GetBooksByTitle(title);
    }
}
