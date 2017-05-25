package com.martin.models;

/**
 *
 * @author Martin
 */
public class Car {
    private String plate;
    
    public Car()
    {
        this.plate = "";
    }
    
    public Car(String plate)
    {
        this.plate = plate;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}
