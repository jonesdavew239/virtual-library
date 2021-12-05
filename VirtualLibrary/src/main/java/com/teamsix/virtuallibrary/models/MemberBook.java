/*
 * Team 6 (Amy Osborne, Gabriel Agbo, Tyree McDowell, David Jones)
 * Virtual Library Project
 * C211
 * 12/2/2021
 */
package com.teamsix.virtuallibrary.models;

import java.util.Date;

public class MemberBook {
    
    private int memberId;
    private int bookId;
    private Date dateLoaned;
    private Date dateDue;
    private Date dateReturned;
    
    MemberBook (int memberId, int bookId, Date dateLoaned, Date dateDue, 
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
