package com.martin.main;

import com.martin.classes.Car;
import com.martin.classes.Date;
import com.martin.classes.Time;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Martin
 */

public class main {

    static Scanner in = new Scanner(System.in);
    
    private static String readString(String message)
    {
        String input;
        System.out.println(message);
        input = in.nextLine();
        
        return input;
    }
    
    public static void main(String[] args) {
        Date date = new Date();
        Time time = new Time();
        Car car = new Car();
        
        String dateStr;
        String timeStr;
        String plate;
        
        boolean restricted = false;
        
        do
        {
            dateStr = readString("Ingrese la fecha en el formato dd/mm/yyyy");
        } while(!date.insertDate(dateStr));
        
        do
        {
            timeStr = readString("Ingrese la hora en el formato hh:mm");
        } while(!time.insertHour(timeStr));
        
        do
        {
            plate = readString("Ingrese la placa del auto en el formato ABC-123 ó ABC-1234");
        } while(!car.setPlate(plate));
        
        if(car.getLastNumber() == date.getRestrictedDigits()[0] || car.getLastNumber() == date.getRestrictedDigits()[1])
        {
            if((time.getHour() >= 7 && time.getHour() <= 8) || (time.getHour() >= 16 && time.getHour() <= 18))
            {
                restricted = true;
            } else if(time.getHour() == 9 || time.getHour() == 19)
            {
                if(time.getMinute() <= 30)
                {
                    restricted = true;
                }
            }
        }
        
        if(restricted)
        {
            System.out.println("Su vehículo NO puede transitar.");
        } else {
            System.out.println("Su vehículo SI puede transitar.");
        }
    }
    
}
