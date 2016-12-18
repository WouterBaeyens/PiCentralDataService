/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.centraldataservice;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.AUTO;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Wouter
 */
@Entity(name="Temperature")
@NamedQueries({
    @NamedQuery(name="Temperature.getAll", query="select t from Temperature t"),
    @NamedQuery(name="Temperature.getAfter", query="select t from Temperature t where t.time > :param"),
    //@NamedQuery(name="Temperature.getDay", query="select h from Humidity where ts >= now()::date and ts < now()::date + interval '1 day';")
    @NamedQuery(name="Temperature.getDay", query="select t from Temperature t where t.time > :start and t.time < :end")
})
public class TemperatureEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
        
            
    private double temperature;
    
    private Timestamp time;
    
    public TemperatureEntity(){}
        
    public TemperatureEntity(double temp){
        this.temperature = temp;
            setTime(Timestamp.from(Instant.now()));

    }


    /**
     * @return the temperature
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * @param temperature the temperature to set
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    /**
     * @return the time
     */
    public Timestamp getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Timestamp time) {
        this.time = time;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
    
    public String toString(){
        return "" + temperature + "; " + time; 
    }
}
