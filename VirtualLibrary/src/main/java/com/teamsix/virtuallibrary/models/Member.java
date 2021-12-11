/*
 * Team 6 (Amy Osborne, Gabriel Agbo, Tyree McDowell, David Jones)
 * Virtual Library Project
 * C211
 * 12/2/2021
 */
package com.teamsix.virtuallibrary.models;

import java.util.ArrayList;
import java.util.Date; 
import java.util.Scanner;

public class Member {
    
    Scanner input = new Scanner(System.in);
    
    public int memberId;
    public int libraryId;
    public String memberFirstName;
    public String memberLastName;
    public String memberPhoneNumber;
    public String memberEmail; 
    public Date dateCreated; 
    public String status; 
    public Boolean isActive;
    public ArrayList<MemberBook> memberBooks;
    
    public Member(int memberId) {
        this.memberId = memberId;
        this.dateCreated = new java.util.Date();
        this.libraryId = 1;
        this.isActive = true;
        this.status = "Active";
        
        System.out.println("Enter Member First Name:");
        this.memberFirstName = input.nextLine();
        
        System.out.println("Enter Member Last Name:");
        this.memberLastName = input.nextLine();
        
        System.out.println("Enter Member Phone Number:");
        this.memberPhoneNumber = input.nextLine();
        
        System.out.println("Enter Member Email Address:");
        this.memberEmail = input.nextLine();
        
        this.memberBooks = new ArrayList<MemberBook>();
    }
    
    public Member (int memberId, int libraryId, String memberFirstName, 
            String memberLastName, String memberPhoneNumber, 
            String memberEmail, Date dateCreated, String status, 
            Boolean isActive) {
        
        this.memberId = memberId;
        this.libraryId = libraryId; 
        this.memberFirstName = memberFirstName;
        this.memberLastName = memberLastName;
        this.memberPhoneNumber = memberPhoneNumber;    
        this.memberEmail = memberEmail; 
        this.dateCreated = dateCreated;
        this.status = status; 
        this.isActive = isActive;
        this.memberBooks = new ArrayList<MemberBook>();
    }
    
    public int getMemberId () {
        return this.memberId;
    }
   
    public void setMemberId (int memberId) {
        this.memberId = memberId;
    }
    
    public int getLibraryId () {
        return this.libraryId;
    }
   
    public void setLibraryId (int libraryId) {
        this.libraryId = libraryId;
    }
    
    public String getMemberFirstName () {
        return this.memberFirstName; 
    }
    
    public void setMemberFirstName (String memberFirstName) {
        this.memberFirstName = memberFirstName; 
    }
    
    public String getMemberLastName () {
        return this.memberLastName; 
    }
    
    public void setMemberLastName (String memberLastName) {
        this.memberLastName = memberLastName; 
    }
    
    public String getMemberPhoneNumber () {
        return this.memberPhoneNumber; 
    }
    
    public void setMemberPhoneNumber (String memberPhoneNumber) {
        this.memberPhoneNumber = memberPhoneNumber; 
    }
    
    public String getMemberEmail () {
        return this.memberEmail; 
    }
    
    public void setMemberEmail (String memberEmail) {
        this.memberEmail = memberEmail; 
    }
    
    public Date getDateCreated () {
        return this.dateCreated;
    }
    
    public void setDateCreated (Date dateCreated) {
        this.dateCreated = dateCreated; 
    }
    
    public String getStatus () {
        return this.status; 
    }
    
    public void setStatus (String status) {
        this.status = status; 
    }
    
    public boolean getIsActive () {
        return this.isActive;
    }
   
    public void setIsActive (boolean isActive) {
        this.isActive = isActive;
    }
    
    public void addMemberBook(MemberBook memberBook) {
        this.memberBooks.add(memberBook);
    }
    
    public void removeMemberBook(int bookId) {
        for(MemberBook memberBook : this.memberBooks){
            if(memberBook.bookId == bookId){
                this.memberBooks.remove(memberBook);
            }
        }  
    }
}