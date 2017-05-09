package com.martin.test;

import com.martin.classes.Car;
import java.util.Scanner;

/**
 *
 * @author Martin
 */

public class TestCar {
    
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        Car car = new Car();
        String plateStr;
        
        System.out.println("Ingrese la placa");
        plateStr = in.nextLine();
        
        if(car.setPlate(plateStr))
        {
            System.out.println("La placa ingresada es: " + car.getPlate());
            System.out.println("El ultimo digito es: " + car.getLastNumber());
        } else {
            System.out.println("Ingrese una placa válida");
        }
    }
}
