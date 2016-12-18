/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.centraldataservice;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Wim Creuwels
 */
public class RestService {
    DataContainerDb db;

    public RestService() {
        db = new DataContainerDb();
    }

        @GET
	@Path("/get/day")
        @Consumes("text/plain")
	@Produces("text/json")
	public Map<String, List> getData(Timestamp s)
	{
		return db.getDataForDay(s);
	}
        
        @GET
	@Path("/get/after")
        @Consumes("text/plain")
	@Produces("text/json")
	public Map<String, List> getDataAfter(Timestamp s)
	{
		return db.getDataAfter(s);
	}
        
        @GET
        @Path("/get")
        @Produces("text/json")
        public Map<String, List> getAll(){
            return db.getAllData();
        }
}
