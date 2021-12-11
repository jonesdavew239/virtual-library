/*
 * Team 6 (Amy Osborne, Gabriel Agbo, Tyree McDowell, David Jones)
 * Virtual Library Project
 * C211
 * 12/2/2021
 */
package Repositories;

import java.util.ArrayList;
import java.util.Scanner;
import com.teamsix.virtuallibrary.models.Member;
import com.teamsix.virtuallibrary.models.MemberBook;


public class MemberRepo {
    
    private ArrayList<Member> _members = new ArrayList<Member>();
    Scanner input = new Scanner(System.in);
    
    public MemberRepo(ArrayList<Member> members){
        _members = members;
    }
    
    public Member CreateMember(){
        Member member = new Member(_members.size() + 1);
        return CreateMember(member);
    }
    
    public Member CreateMember(Member member){
        Member result = this.GetMember(member.memberId);
        
        if(result != null){
            System.out.println("Member already exists with memberId " + member.memberId);
            return null;
        }
        
        _members.add(member);
        System.out.println("Member created.");
        return member;
    }
    
    public Member UpdateMember(){
        System.out.println("Enter a member id to update.");
        int memberId = input.nextInt();
        Member result = this.GetMember(memberId);

        if(result != null) {
            System.out.println("Enter a first name");
            String firstName = input.next();
            result.setMemberFirstName(firstName);

            System.out.println("Enter a last name");
            String lastName = input.next();
            result.setMemberLastName(lastName);

            System.out.println("Enter a phone number");
            String phone = input.next();
            result.setMemberPhoneNumber(phone);

            System.out.println("Enter a email address");
            String email = input.next();
            result.setMemberEmail(email);

            return this.UpdateMember(result);                        
        }
        return null;
    }
    
    public Member UpdateMember(Member member){
        Member result = this.GetMember(member.memberId);
        
        if(result != null){            
            int index = _members.indexOf(result);
            _members.set(index, member);        
        
            System.out.println("Member updated.");
            return member;   
        }       
        
        return null;
    }
    
    public void DeleteMember(){
        System.out.println("Enter a member id to delete.");
        int memberId = input.nextInt();
        this.DeleteMember(memberId);
    }
    
    public void DeleteMember(int memberId){
        Member member = this.GetMember(memberId);
        
        if(member == null) return;
        
        _members.remove(member);
        System.out.println("Member deleted.");
    }
    
    public Member GetMember(){
        System.out.println("Enter a member id");
        int memberId = input.nextInt();
        Member result = this.GetMember(memberId);
        
        if(result == null){
            System.out.println("Member not found.");
            return null;
        }
        
        System.out.println("Id: " + result.memberId + ", Name: " + result.memberFirstName + " " + result.memberLastName);
        System.out.println("Phone: " + result.memberPhoneNumber);
        System.out.println("Email: " + result.memberEmail);
        
        System.out.println("Checked out books:");
        if(result.memberBooks != null){
            if(result.memberBooks.size() > 0){                
                for(MemberBook memberBook : result.memberBooks){
                    System.out.println("BookId: " + memberBook.bookId + ", Due back: " + memberBook.dateDue);
                }
            }
        } else {
            System.out.println("No books checked out.");
        }
                
        
        return result;
    }
    
    public Member GetMember(int memberId){
        if(_members != null){
            for(Member member : _members){
                if(member.getMemberId() == memberId){
                    return member;
                }
            }
        }                
        return null;
    }
    
    public ArrayList<Member> GetMembers(){        
        return _members;
    }
    
    public void ListMembers(){
        for(Member member : _members){
            System.out.println("Id: " + member.memberId + ", Name: " + member.memberFirstName + " " + member.memberLastName);
        } 
    }
}
