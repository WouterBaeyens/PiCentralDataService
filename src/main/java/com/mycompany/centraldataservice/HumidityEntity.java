/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.centraldataservice;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/*
select *
from test1
where ts >= now()::date and ts < now()::date + interval '1 day';
*/

/**
 *
 * @author Wouter
 */
@Entity(name="Humidity")
@NamedQueries({
@NamedQuery(name="Humidity.getAll", query="select h from Humidity h"),
//@NamedQuery(name="Humidity.sameDay", query="select h from Humidity where ts >= now()::date and ts < now()::date + interval '1 day';"),
@NamedQuery(name="Humidity.getAfter", query="select h from Humidity h where h.time > :param"),
@NamedQuery(name="Humidity.getDay", query="select h from Humidity h where h.time > :param")
})
public class HumidityEntity implements Serializable {

    //private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
 private double humidity; 
    
    private Timestamp time;
    
    public HumidityEntity(){
        
    }

    public HumidityEntity(double humidity){
        setHumidity(humidity);
        setTime(Timestamp.from(Instant.now()));
    }
    
    /**
     * @return the humidity
     */
    public double getHumidity() {
        return humidity;
    }

    /**
     * @param humidity the humidity to set
     */
    public void setHumidity(double humidity) {
        this.humidity = humidity;
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

    public String toString(){
        return "" + humidity + "; " + time; 
    }
}
