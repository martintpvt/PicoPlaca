package com.martin.classes;

import java.util.regex.Pattern;

/**
 *
 * @author Martin
 */
public class Car {
    private String plate;
    private int lastNumber;

    public String getPlate() {
        return plate;
    }

    public boolean setPlate(String plate) {
        String[] plateComponents = plate.split("-");
        Pattern pattern = Pattern.compile("[A-Za-z]");
        int lastNumber;
        boolean inserted = false;
        
        if(plateComponents.length == 2)
        {
            if(plateComponents[0].length() == 3 && plateComponents[1].length() >= 3 && plateComponents[1].length() <= 4 && pattern.matcher(plateComponents[0]).find())
            {
                try
                {
                    lastNumber = Integer.parseInt(plateComponents[1].substring(plateComponents[1].length() - 1));
                    
                    this.plate = plate.toUpperCase();
                    this.lastNumber = lastNumber;
                    
                    inserted = true;
                } catch(Exception ex)
                {
                    
                }
            }
        }
        
        return inserted;
    }

    public int getLastNumber() {
        return lastNumber;
    }
}
