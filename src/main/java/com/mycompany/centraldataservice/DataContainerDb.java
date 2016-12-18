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
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.eclipse.persistence.internal.jpa.EntityManagerFactoryImpl;

/**
 *
 * @author Wouter
 */
public class DataContainerDb {
   
    //@PersistenceContext (unitName = "PersistenceUnit")
    EntityManagerFactory emF;
    EntityManager em;

    public DataContainerDb() {
        emF = Persistence.createEntityManagerFactory("PersistenceUnit");
        em = emF.createEntityManager();
    }
    
    
    
    public Map<String,List> getDataForDay(Timestamp time){
        Map<String, List> results = new HashMap<String, List>();
        try {
            em.getTransaction().begin();
            Query query1 = em.createNamedQuery("Humidity.getDay");
             List<HumidityEntity> humidity = new ArrayList<>(query1.getResultList());
             results.put("humidity", humidity);
             
             Query query2 = em.createNamedQuery("Temperature.getDay");
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
            
             results.put("Temperature", temperature);
             results.put("humidity", humidity);
             
             return results;
        } catch (Exception e) {
            em.getTransaction().rollback();
            String message = "Error getting data for day";
            throw new RuntimeException(message + e.getMessage(),e);
        }  
    }
    
    public void addHumidityData(HumidityEntity humidityData){
        try{
            System.err.println("start stuff: " + em);
            em.getTransaction().begin();
            System.out.println("trans started");
            em.persist(humidityData);
            System.out.println("persisted");
            em.getTransaction().commit();
            System.out.println("comitted");
        } catch(Exception e){
            throw new RuntimeException("[Error adding data]" + e.getMessage());
        }
    }

        public void addTemperatureData(TemperatureEntity temperatureData){
        try{
            System.err.println("start stuff: " + em);
            em.getTransaction().begin();
            System.out.println("trans started");
            em.persist(temperatureData);
            System.out.println("persisted");
            em.getTransaction().commit();
            System.out.println("comitted");
        } catch(Exception e){
            throw new RuntimeException("[Error adding data]" + e.getMessage());
        }
    }
    
    public Map<String,List> getDataAfter(Timestamp time){
                Map<String, List> results = new HashMap<String, List>();
        try {
            em.getTransaction().begin();
            Query query1 = em.createNamedQuery("Humidity.getAfter");
            query1.setParameter("param", time);
            List<HumidityEntity> humidity = new ArrayList<>(query1.getResultList());
             results.put("humidity", humidity);
             
             Query query2 = em.createNamedQuery("Temperature.getAfter");
             query2.setParameter("param", time);
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
