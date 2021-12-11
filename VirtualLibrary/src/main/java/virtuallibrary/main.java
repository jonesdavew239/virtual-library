/*
 * Team 6 (Amy Osborne, Gabriel Agbo, Tyree McDowell, David Jones)
 * Virtual Library Project
 * C211
 * 12/2/2021
 */

package virtuallibrary;

import Repositories.BookRepo;
import Repositories.LibraryRepo;
import Repositories.MemberRepo;
import com.teamsix.virtuallibrary.models.Book;
import com.teamsix.virtuallibrary.models.Member;
import com.teamsix.virtuallibrary.models.MemberBook;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    
    private static ArrayList<Book> _books = new ArrayList<Book>();
    private static ArrayList<Member> _members = new ArrayList<Member>();  
    private static Scanner input = new Scanner(System.in);
    private static BookRepo _bookRepo;
    private static MemberRepo _memberRepo;
    private static LibraryRepo _libraryRepo;
    
    public static void main(String[] args) {        
        SeedLibraryBooks();
        SeedLibraryMembers();
        
        _bookRepo = new BookRepo(_books);
        _memberRepo = new MemberRepo(_members);
        _libraryRepo = new LibraryRepo(_bookRepo, _memberRepo);
        
        int choice;
        
        System.out.println("--- Welcome to the your local Library ---");
        System.out.println(" Please Select From The Following Options:");
        System.out.println("------------------------------------------");
        
        do {
            MainMenu();
            choice = input.nextInt();
            
            switch(choice){
                case 1:
                    // Go to Library Menu
                    LibraryMenu();                                        
                    break;
                case 2:
                    // Go to member menu
                    MemberMenu();
                    break;
                case 3:
                    // Go to book menu
                    BookMenu();
                    break;
                default:
                    System.out.println("Choice should be between 1-3 or 0 to exit.");
                    break;
            }
        
        } while (choice != 0);
    }  
    
    public static void MainMenu(){  
        System.out.println();
        System.out.println("Enter 0 to Exit Application.");
        System.out.println("Enter 1 to Go to the Library menu.");        
        System.out.println("Enter 2 to Go to the Members menu.");
        System.out.println("Enter 3 to Go to the Books menu.");
    }
    
    public static void LibraryMenu(){  
        int choice;
        
        do{
            System.out.println();
            System.out.println("Enter 1 to Go to main menu.");
            System.out.println("Enter 2 to Checkout a library book.");
            System.out.println("Enter 3 to Return a library book.");
            System.out.println("Enter 4 to Search library books"); 
            
            choice = input.nextInt();
            
            switch(choice){
                case 2:
                    _libraryRepo.CheckOutBook();
                    break;
                case 3:
                    _libraryRepo.ReturnBook();
                    break;
                case 4:
                    _libraryRepo.SearchBooks();
                    break;
                default:
                    if(choice != 1)
                        System.out.println("Choice should be between 2-4 or 1 to go to the main menu.");
                    break;
            }
            
        } while (choice != 1);
    }
    
    public static void MemberMenu(){
        int choice;
        
        do{
            System.out.println();
            System.out.println("Enter 1 to Go to main menu.");
            System.out.println("Enter 2 to Add new library member.");
            System.out.println("Enter 3 to Update a library member.");
            System.out.println("Enter 4 to Delete a library member.");
            System.out.println("Enter 5 to Get a list of library members.");
            System.out.println("Enter 6 to Get a member details.");
            
            choice = input.nextInt();
            
            switch(choice){
                case 2:
                    _memberRepo.CreateMember();                    
                    break;
                case 3:
                    _memberRepo.UpdateMember();
                    break;
                case 4:                    
                    _memberRepo.DeleteMember();
                    break;
                case 5:
                    _memberRepo.ListMembers();
                    break;
                case 6:
                    _memberRepo.GetMember();
                    break;
                default:
                    if(choice != 1)
                        System.out.println("Choice should be between 2-5 or 1 to go to the main menu.");
                    break;
            }
            
        } while (choice != 1);
    }
    
    public static void BookMenu(){
        int choice;
        
        do{
            System.out.println();
            System.out.println("Enter 1 to Go to main menu.");
            System.out.println("Enter 2 to Add new library book.");
            System.out.println("Enter 3 to Update a library book.");
            System.out.println("Enter 4 to Delete a library book.");
            System.out.println("Enter 5 to Get a list of library books.");
            
            choice = input.nextInt();
            
            switch(choice){
                case 2:
                    _bookRepo.AddBook();
                    break;
                case 3:
                    _bookRepo.UpdateBook();
                    break;
                case 4:
                    _bookRepo.DeleteBook();                    
                    break;
                case 5:
                    _bookRepo.ListBooks();
                    break;
                default:
                    if(choice != 1)
                        System.out.println("Choice should be between 2-5 or 1 to go to the main menu.");
                    break;
            }
            
        } while (choice != 1);
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
