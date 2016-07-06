package com.github.learningjava;

import java.util.Scanner;


public class BurnItOff {
    public static void main (String[] args){

        double bigMacs = 0;
        double caloriesConsumed = 0;
        double milesToWalk = 0;
        double mediumFrenchFries = 0;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("How many Big Macs did you eat?");

        bigMacs = keyboard.nextDouble();
        System.out.print("\nHow many medium french fries did you eat?");
        mediumFrenchFries = keyboard.nextDouble();

        caloriesConsumed = ((bigMacs * 590)+ (mediumFrenchFries * 384));

        milesToWalk = caloriesConsumed/93.5;

        System.out.println("Wow! You consumed " + caloriesConsumed +" calories");
        System.out.println("You need to walk " + milesToWalk +" miles");
    }
}
