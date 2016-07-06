package com.github.learningjava.hotelratecalculator;

import java.util.Currency;

/**
 * Get the base room rate for a zip code.
 * Only supports zip codes - 97006, 97007, 97220
 */
public class TaxRateByZipCodeService {



    public double getTaxPercentForZipCode ( String zipCode) {

        double percent = 0.0;
        if (zipCode == null){
            throw new IllegalArgumentException("Null Zip Code is not supported");
        }
        switch (zipCode) {
            case "97006":
                percent = 11.0;
                break;
            case "97007":
                percent = 12.6;
                break;
            case "97220":
                percent = 11.3;
                break;
            default:
                throw new IllegalArgumentException(String.format("Zip Code %s is not supported", zipCode));
        }
        return percent;
    }

}
