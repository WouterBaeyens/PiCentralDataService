/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.centraldataservice;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wouter
 */
public class DataContainerDbTest {
    
    private DataContainerDb db;
    
    public DataContainerDbTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        db = new DataContainerDb();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddData(){
        
    }
    
    @Test
    public void testAddStuff(){
        db.addHumidityData(new HumidityEntity(13.5));
        Map<String,List> data = db.getAllData();
        
    }
    
    /**
     * Test of getDataForDay method, of class DataContainerDb.
     
    @Test
    public void testGetDataForDay() {
        System.out.println("getDataForDay");
        Timestamp time = null;
        DataContainerDb instance = new DataContainerDb();
        Map<String, List> expResult = null;
        Map<String, List> result = instance.getDataForDay(time);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllData method, of class DataContainerDb.
     
    @Test
    public void testGetAllData() {
        System.out.println("getAllData");
        DataContainerDb instance = new DataContainerDb();
        Map<String, List> expResult = null;
        Map<String, List> result = instance.getAllData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataAfter method, of class DataContainerDb.
     
    @Test
    public void testGetDataAfter() {
        System.out.println("getDataAfter");
        Timestamp time = null;
        DataContainerDb instance = new DataContainerDb();
        Map<String, List> expResult = null;
        Map<String, List> result = instance.getDataAfter(time);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeRegistration method, of class DataContainerDb.
     
    @Test
    public void testRemoveRegistration() {
        System.out.println("removeRegistration");
        Timestamp time = null;
        DataContainerDb instance = new DataContainerDb();
        instance.removeRegistration(time);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
}
