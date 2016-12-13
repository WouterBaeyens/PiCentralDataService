/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.centraldataservice;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Wouter
 */
public class DataContainerDb {
   
    @PersistenceContext (unitName = "PersistenceUnit")
    EntityManager em;
    
    public Map<String,List> getDataForDay(Timestamp time){
        Map<String, List> results = new HashMap<String, List>();
        try {
            em.getTransaction().begin();
            Query query1 = em.createNamedQuery("Humidity.sameDay");
             List<HumidityEntity> humidity = new ArrayList<>(query1.getResultList());
             results.put("humidity", humidity);
             
             Query query2 = em.createNamedQuery("Temperature.sameday");
             List<TemperatureEntity> temperature = new ArrayList<>(query2.getResultList());
             results.put("temperature", temperature);
             em.getTransaction().commit();
            
             return results;
        } catch (Exception e) {
            em.getTransaction().rollback();
            String message = "Error getting data for day";
            throw new RuntimeException(message + e.getMessage(),e);
        }   
    }
    
    public Map<String,List> getAllData(){
                Map<String, List> results = new HashMap<String, List>();
        try {
            em.getTransaction().begin();
            Query query1 = em.createNamedQuery("Humidity.getAll");
             List<HumidityEntity> humidity = new ArrayList<>(query1.getResultList());
            
             Query query2 = em.createNamedQuery("Temperature.getAll");
             List<TemperatureEntity> temperature = new ArrayList<>(query2.getResultList());
             em.getTransaction().commit();
            
             return results;
        } catch (Exception e) {
            em.getTransaction().rollback();
            String message = "Error getting data for day";
            throw new RuntimeException(message + e.getMessage(),e);
        }  
    }
    
    public void addHumidityData(HumidityEntity humidityData){
        try{
            em.getTransaction().begin();
            em.persist(humidityData);
            em.getTransaction().commit();
        } catch(Exception e){
            throw new RuntimeException("Error adding data");
        }
    }
    
    public Map<String,List> getDataAfter(Timestamp time){
                Map<String, List> results = new HashMap<String, List>();
        try {
            em.getTransaction().begin();
            Query query1 = em.createNamedQuery("Humidity.sameDay");
             List<HumidityEntity> humidity = new ArrayList<>(query1.getResultList());
             results.put("humidity", humidity);
             
             Query query2 = em.createNamedQuery("Temperature.sameday");
             List<TemperatureEntity> temperature = new ArrayList<>(query2.getResultList());
             results.put("temperature", temperature);
             em.getTransaction().commit();
            
             return results;
        } catch (Exception e) {
            em.getTransaction().rollback();
            String message = "Error getting data for day";
            throw new RuntimeException(message + e.getMessage(),e);
        }   
    }
    
    public void removeRegistration(Timestamp time){
        
    }
            
      
    
}
