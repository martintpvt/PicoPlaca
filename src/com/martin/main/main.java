package com.martin.main;

import com.martin.models.Car;
import com.martin.controllers.Car_Controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
    
    private static boolean isRestricted(int lastNumber, Calendar calendar)
    {
        boolean restricted = false;
        
        List<Integer> restrictedDigits = new ArrayList<>();
        switch(calendar.get(Calendar.DAY_OF_WEEK))
        {
            case 1: case 7:
            {
                return false;
            }
            case 2:
            {
                restrictedDigits.add(0);
                restrictedDigits.add(1);
                break;
            }
            case 3:
            {
                restrictedDigits.add(2);
                restrictedDigits.add(3);
                break;
            }
            case 4:
            {
                restrictedDigits.add(4);
                restrictedDigits.add(5);
                break;
            }
            case 5:
            {
                restrictedDigits.add(6);
                restrictedDigits.add(7);
                break;
            }
            case 6:
            {
                restrictedDigits.add(8);
                restrictedDigits.add(9);
                break;
            }
        }
        
        for(int cont = 0; cont < restrictedDigits.size(); cont++)
        {
            if(lastNumber == restrictedDigits.get(cont))
                restricted = true;
        }
        
        return restricted;
    }
    
    public static void main(String[] args) {
        String dateStr;
        String timeStr;
        String plate;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd HH:mm");
        
        Date date;
        Calendar calendar;
        
        Car car;
        Car_Controller carController = new Car_Controller();
        
        dateStr = readString("Ingrese la fecha en el formato yyyy-mm-dd");
        timeStr = readString("Ingrese la hora en el formato HH:mm");
        
        plate = readString("Ingrese la placa del auto en el formato ABC-0123");
        
        car = carController.CreateCar(plate);
        
        try
        {
            date = sdf.parse(dateStr + " " + timeStr);
            
            calendar = Calendar.getInstance();
            calendar.setTime(date);
            
            if(car != null)
            {
                if(isRestricted(carController.GetLastNumber(car), calendar))
                    System.out.println("Su vehículo NO puede transitar");
                else
                    System.out.println("Su vehículo SI puede transitar");
            } else {
                System.out.println("No ingreso una placa valida");
            }
        } catch (ParseException ex)
        {
            System.out.println("No ingreso una fecha valida");
        }
    }
    
}
