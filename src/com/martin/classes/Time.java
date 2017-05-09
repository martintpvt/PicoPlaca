package com.martin.classes;

/**
 *
 * @author Martin
 */
public class Time {
    private int hour;
    private int minute;

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }
    
    public boolean insertHour(String hourStr)
    {
        boolean inserted = false;
        int hour;
        int minute;
        String[] hourComponents = hourStr.split(":");
        
        if(hourComponents.length == 2)
        {
            try
            {
                hour = Integer.parseInt(hourComponents[0]);
                minute = Integer.parseInt(hourComponents[1]);
                
                if(hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59)
                {
                    this.hour = hour;
                    this.minute = minute;

                    inserted = true;
                }
            } catch(Exception ex)
            {
                
            }
            
            return inserted;
        }
        
        
        
        return inserted;
    }
}
