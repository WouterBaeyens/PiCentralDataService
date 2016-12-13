/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.centraldataservice;

import java.sql.Timestamp;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Wouter
 */
public class DataContainerDb {
   
    @PersistenceContext (unitName = "PersistenceUnit")
    EntityManager em;
    
    public void getDataForDay(Timestamp time){
        
    }
    
    public void getAllData(){
        
    }
    
    public void getDataAfter(Timestamp time){
        
    }
    
    public void removeRegistration(Timestamp time){
        
    }
            
      
    
}
