package com.martin.controllers;

import com.martin.models.Car;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Martin
 */
public class Car_ControllerTest {
    
    public Car_ControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ChangePlate method, of class Car_Controller.
     */
    @Test
    public void testChangePlate() {
        System.out.println("ChangePlate");
        Car car = new Car();
        String plate = "piw-0867";
        Car_Controller instance = new Car_Controller();
        boolean expResult = true;
        boolean result = instance.ChangePlate(car, plate);
        assertEquals(expResult, result);
    }

    /**
     * Test of GetLastNumber method, of class Car_Controller.
     */
    @Test
    public void testGetLastNumber() {
        System.out.println("GetLastNumber");
        Car car = new Car();
        car.setPlate("piw-0867");
        Car_Controller instance = new Car_Controller();
        int expResult = 7;
        int result = instance.GetLastNumber(car);
        assertEquals(expResult, result);
    }

    /**
     * Test of ValidatePlate method, of class Car_Controller.
     */
    @Test
    public void testValidatePlate() {
        System.out.println("ValidatePlate");
        String plate = "piw-0867";
        Car_Controller instance = new Car_Controller();
        boolean expResult = true;
        boolean result = instance.ValidatePlate(plate);
        assertEquals(expResult, result);
    }
    
}
