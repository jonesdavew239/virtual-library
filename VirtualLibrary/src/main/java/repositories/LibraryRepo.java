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
import com.teamsix.virtuallibrary.models.Member;
import com.teamsix.virtuallibrary.models.MemberBook;

public class LibraryRepo {
    private BookRepo _bookRepo;
    private MemberRepo _memberRepo;
    private ArrayList<Book> _checkedOutBooks = new ArrayList<Book>();
    Scanner input = new Scanner(System.in);
    
    public LibraryRepo(BookRepo bookRepo, MemberRepo memberRepo){
        _bookRepo = bookRepo;
        _memberRepo = memberRepo;
    }
    
    public void CheckOutBook(){
        MemberBook memberBook = new MemberBook();
        Book book = _bookRepo.GetBook(memberBook.bookId);
        Member member = _memberRepo.GetMember(memberBook.memberId);
        
        if(CheckOutBook(book)){
            member.addMemberBook(memberBook);
        }
    }
        
    public boolean CheckOutBook(Book book){
        for(Book checkOutBook : _checkedOutBooks){
            if(checkOutBook.getBookId() == book.bookId){
                System.out.println("Book already checked out.");
                return false;
            }
        }
        
        _checkedOutBooks.add(book);
                
        System.out.println("Book titled " + book.bookTitle + " successfully checked out! Enjoy!");
        return true;
    }
    
    public void ReturnBook(){
        System.out.println("Enter a book id to return:");
        int bookId = input.nextInt();
        
        Book book = _bookRepo.GetBook(bookId);
        
        if(book != null){
            this.ReturnBook(book);
            
            try
            {
                ArrayList<Member> members = _memberRepo.GetMembers();
                for(Member member : members){
                    for(MemberBook memberBook : member.memberBooks){
                        if(memberBook.bookId == bookId){
                            member.memberBooks.remove(memberBook);
                        }
                    }
                }
            } catch (Exception e){
                // todo: for now do nothing
            }
        }
    }
    
    public boolean ReturnBook(Book book){
        for(Book checkOutBook : _checkedOutBooks){
            if(checkOutBook.getBookId() == book.bookId){
                _checkedOutBooks.remove(book);
                System.out.println("Book titled " + book.bookTitle + " successfully been returned! Thanks!");
                return true;
            }
        }
        
        System.out.println("Book titled " + book.bookTitle + " doesn't appear to be checked out.");
        return false;
    }
    
    public void SearchBooks(){
        System.out.println("Enter a title to search:");
        String search = input.next();
        
        ArrayList<Book> results = _bookRepo.GetBooksByTitle(search);
        
        if(results.size() > 0){
            System.out.println("Results:");
            
            for(Book book : results){
                System.out.println("Id: " + book.bookId + ", " + book.bookTitle + ", " + book.bookAuthor + ", " + book.yearPublished);
            }
        } else {
            System.out.println("No books found with that title.");
        }    
    }    
}
