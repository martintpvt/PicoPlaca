package com.martin.test;

import com.martin.classes.Date;
import java.util.Scanner;

/**
 *
 * @author Martin
 */
public class TestDate {
    
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        String dateStr;
        
        System.out.print("Fecha: ");
        dateStr = in.nextLine();
        
        Date date = new Date();
        
        if(date.insertDate(dateStr))
        {
            System.out.println("Restricted digits:");
            if(date.getRestrictedDigits() != null)
            {
                System.out.println(date.getRestrictedDigits()[0]);
                System.out.println(date.getRestrictedDigits()[1]);
            } else {
                System.out.println("No hay restricción de carros");
            }
        } else {
            System.out.println("No insertó una fecha válida");
        }
    }
}
