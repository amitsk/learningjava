package com.github.learningjava.hotelratecalculator;

import java.util.Currency;
import java.util.Scanner;

/**
 * MAin class for running the program. http://docs.oracle.com/javase/tutorial/essential/io/cl.html
 */
public class Main {
    public static void main(String... args) {
        String zipCode;
        int month;
        Scanner in = new Scanner(System.in);

        do {
            // and stores into zipcode variable
            System.out.println("Enter a valid ZipCode ( Enter q to quit ):");
             zipCode = in.next();
            if( zipCode != null && zipCode.equalsIgnoreCase("q")) {
                System.exit( 0 );
            }

            // Reads a integer from the console
            System.out.println("Enter a valid month number[1-12]:");
            month = in.nextInt();
            if( zipCode == null || month <= 0) {
                System.out.print("Calculation failed : Valid Zipcode and Month are required !!! ");
                System.exit( 1 );
            }

            RoomRateCalculator roomRateCalculator = new RoomRateCalculator(
                    new BaseRateForZipCodeService(Currency.getInstance("USD")),
                    new DiscountRateService(),
                    new TaxRateByZipCodeService());

            double totalRoomRate = roomRateCalculator.getTotalRoomRate(new RoomRateCalculator.RoomRateInput(zipCode, month));
            System.out.println( String.format("The total room rate for %s and month %d is %f" ,
                    zipCode,month, totalRoomRate) );

        } while (true);
    }
}
