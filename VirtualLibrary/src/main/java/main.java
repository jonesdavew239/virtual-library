/*
 * Team 6 (Amy Osborne, Gabriel Agbo, Tyree McDowell, David Jones)
 * Virtual Library Project
 * C211
 * 12/2/2021
 */

import com.teamsix.virtuallibrary.models.Book;
import com.teamsix.virtuallibrary.models.Member;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import repositories.BookRepo;
import repositories.LibraryRepo;
import repositories.MemberRepo;

public class main {
    
    private static ArrayList<Book> _books = new ArrayList<Book>();
    private static ArrayList<Member> _members = new ArrayList<Member>();    
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SeedLibraryBooks();
        SeedLibraryMembers();
        
        BookRepo bookRepo = new BookRepo(_books);
        MemberRepo memberRepo = new MemberRepo(_members);
        LibraryRepo libraryRepo = new LibraryRepo(bookRepo, memberRepo);
        
        int choice;
        
        System.out.println("----Welcome to the your local Library----");
        System.out.println("Please Select From The Following Options:");
        System.out.println("-----------------------------------------");
        
        do {
            // display menu
            choice = input.nextInt();
            
            switch(choice){
                case 1:
                    // Go to book menu
                    break;
                case 2:
                    // Go to member menu
                    break;
                case 3:
                    // Go to library main menu
                    break;
                default:
                    System.out.println("Choice should be between 1-3 or 0 to exit.");
                    break;
            }
        
        } while (choice != 0);
    }
    
    public static void SeedLibraryBooks(){
        Book book1 = new Book(1, 1, 123456789, "Something Real Good Clark", "Chevy Chase", 1995, false);
        _books.add(book1);
    }
    
    public static void SeedLibraryMembers(){
        Member member1 = new Member(1, 1, "Seth", "Davis", "317-555-9999", "sethdavis@gmail.com", new java.util.Date(), "Active", true);
        _members.add(member1);
    }
}