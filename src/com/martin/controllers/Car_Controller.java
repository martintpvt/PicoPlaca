package com.martin.controllers;

import com.martin.models.Car;
import java.util.regex.Pattern;

/**
 *
 * @author Martin
 */
public class Car_Controller {
    public Car CreateCar(String plate)
    {
        Car car;
        
        if(ValidatePlate(plate))
        {
            car = new Car();
            car.setPlate(plate);
        } else {
            car = null;
        }
        
        return car;
    }
    
    public boolean ChangePlate(Car car, String plate)
    {
        if(ValidatePlate(plate))
        {
            car.setPlate(plate);
            return true;
        } else {
            return false;
        }
    }
    
    public int GetLastNumber(Car car)
    {
        int length = car.getPlate().length() - 1;
        
        try
        {
            return Integer.parseInt(car.getPlate().substring(length));
        } catch (NumberFormatException ex)
        {
            throw(ex);
        }
    }
    
    public boolean ValidatePlate(String plate)
    {
        Pattern pattern = Pattern.compile("^[A-Za-z]{3}-\\d{4}$");
        
        return pattern.matcher(plate).find();
    }
}
