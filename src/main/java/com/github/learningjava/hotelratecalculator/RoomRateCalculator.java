package com.github.learningjava.hotelratecalculator;

/**
 *
 * Get the room rate for a zip code and the month
 *
 */
public class RoomRateCalculator {

    private  BaseRateForZipCodeService baseRateForZipCodeService;
    private TaxRateByZipCodeService taxRateByZipCodeService;

    public RoomRateCalculator(BaseRateForZipCodeService zipCodeService, TaxRateByZipCodeService taxRateByZipCodeService) {
        this.baseRateForZipCodeService = zipCodeService;
        this.taxRateByZipCodeService = taxRateByZipCodeService;
    }

    public double getTotalRoomRate( String zipCode, int month) {
        double taxRate = taxRateByZipCodeService.getTaxPercentForZipCode(zipCode);
        double baseRate = baseRateForZipCodeService.getBaseRateForZipCode(zipCode);

        return baseRate * (1 + getDiscountRateForMonth( month )) + (baseRate * (taxRate/100) ) ;
    }

    public double getDiscountRateForMonth( int month) {
        if( month <=8 && month >=6 ) {
            return 0.5;
        }
        else if ( month == 12 || month == 11  ) {
            return 0.2;
        }
        else if ( month == 3 ) {
            return 0.3;
        }
        else if ( month == 10 || month == 2 || month == 1  ) {
            return -0.3;
        }
        else {
           return 0.0;
        }
    }
}
