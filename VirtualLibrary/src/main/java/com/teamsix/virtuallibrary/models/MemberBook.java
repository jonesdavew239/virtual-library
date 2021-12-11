/*
 * Team 6 (Amy Osborne, Gabriel Agbo, Tyree McDowell, David Jones)
 * Virtual Library Project
 * C211
 * 12/2/2021
 */
package com.teamsix.virtuallibrary.models;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MemberBook {
    
    Scanner input = new Scanner(System.in);
    Calendar calendar = Calendar.getInstance();
    
    public int memberId;
    public int bookId;
    public Date dateLoaned;
    public Date dateDue;
    public Date dateReturned;
    
    public MemberBook(){
        System.out.println("Enter the member id checking out the book:");
        this.memberId = input.nextInt();
        
        System.out.println("Enter the book id to be checked out.");
        this.bookId = input.nextInt();
        
        this.dateLoaned = new java.util.Date();
        
        // book due in 30 days
        calendar.add(Calendar.DATE, 30);
        this.dateDue = calendar.getTime();        
    }
    
    public MemberBook (int memberId, int bookId, Date dateLoaned, Date dateDue, 
            Date dateReturned){
    
        this.memberId = memberId;
        this.bookId = bookId;
        this.dateLoaned = dateLoaned;
        this.dateDue = dateDue;
        this.dateReturned = dateReturned; 
    }
    
    public int getMemberId () {
        return this.memberId;
    }
   
    public void setMemberId (int memberId) {
        this.memberId = memberId;
    }        
    
    public int getBookId () {
        return this.bookId;
    }
   
    public void setBookId (int bookId) {
        this.bookId = bookId;
    }
    
    public Date getDateLoaned () {
        return this.dateLoaned;
    }
    
    public void setDateLoaned (Date dateLoaned) {
        this.dateLoaned = dateLoaned; 
    }
    
    public Date getDateDue () {
        return this.dateDue;
    }
    
    public void setDateDue (Date dateDue) {
        this.dateDue = dateDue; 
    }
    
    public Date getDateReturned () {
        return this.dateReturned;
    }
    
    public void setDateReturned (Date dateReturned) {
        this.dateReturned = dateReturned; 
    }
}