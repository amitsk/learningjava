package com.github.learningjava.hotelratecalculator;

import java.util.Currency;

/**
 * Get the base room rate for a zip code.
 * Only supports zip codes - 97006, 97007, 97220
 *
 */
public class BaseRateForZipCodeService {

    private Currency currency = Currency.getInstance("USD");

    public BaseRateForZipCodeService(Currency currency) {
        this.currency = currency;
    }

    public double getBaseRateForZipCode ( String zipCode) {
        double rate = 0.0;
        if (zipCode == null){
            throw new IllegalArgumentException("Null Zip Code is not supported");
        }
        switch (zipCode) {
            case "97006":
                rate = 100.0;
                break;
            case "97007":
                rate = 130.0;
                break;
            case "97220":
                rate = 140.0;
                break;
            default:
                throw new IllegalArgumentException(String.format("Zip Code %s is not supported", zipCode));
        }
        return rate;
    }

}


