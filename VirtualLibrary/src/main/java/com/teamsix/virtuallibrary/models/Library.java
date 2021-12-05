/*
 * Team 6 (Amy Osborne, Gabriel Agbo, Tyree McDowell, David Jones)
 * Virtual Library Project
 * C211
 * 12/2/2021
 */
package com.teamsix.virtuallibrary.models;

public class Library {
    
    private int libraryId;
    private String libraryName;
    private String libraryCity;
    private String libraryState;
    private int libraryPostalCode;
    private String libraryPhone;
    
    Library (int libraryId, String libraryName, String libraryCity,
             String libraryState, int libraryPostalCode, String 
             libraryPhone){
    
        this.libraryId = libraryId; 
        this.libraryName = libraryName;
        this.libraryCity = libraryCity;
        this.libraryState = libraryState;
        this.libraryPostalCode = libraryPostalCode;
        this.libraryPhone = libraryPhone;
    }
        
    public int getLibraryId () {
        return this.libraryId;
    }
   
    public void setLibraryId (int libraryId) {
        this.libraryId = libraryId;
    }
    
    public String getLibraryName () {
        return this.libraryName; 
    }
    
    public void setLibraryName (String libraryName) {
        this.libraryName = libraryName; 
    }
    
    public String getLibraryCity () {
        return this.libraryCity; 
    }
    
    public void setLibraryCity (String libraryCity) {
        this.libraryCity = libraryCity; 
    }
    
    public String getLibraryState () {
        return this.libraryState; 
    }
    
    public void setLibraryState (String libraryState) {
        this.libraryState = libraryState; 
    }
    
    public int getLibraryPostalCode () {
        return this.libraryPostalCode;
    }
   
    public void setLibraryPostalCode (int libraryPostalCode) {
        this.libraryPostalCode = libraryPostalCode;
    }
    
    public String getLibraryPhone () {
        return this.libraryPhone; 
    }
    
    public void setLibraryPhone (String libraryPhone) {
        this.libraryPhone = libraryPhone; 
    }
   
}
