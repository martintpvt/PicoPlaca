package com.martin.test;

import com.martin.classes.Time;
import java.util.Scanner;

/**
 *
 * @author Martin
 */
public class TestTime {
    
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        String hourStr;
        Time time = new Time();
        
        System.out.println("Ingrese la hora: ");
        hourStr = in.nextLine();
        
        if(time.insertHour(hourStr))
        {
            System.out.println("Hora: " + time.getHour());
            System.out.println("Minuto: " + time.getMinute());
        } else {
            System.out.println("Inserte una hora válida");
        }
    }
}
