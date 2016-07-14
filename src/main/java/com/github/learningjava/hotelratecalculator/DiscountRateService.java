package com.github.learningjava.hotelratecalculator;

public class DiscountRateService {
    public DiscountRateService() {
    }

    public double getDiscountRateForMonth(int month) {
        if (month <= 8 && month >= 6) {
            return 0.5;
        } else if (month == 12 || month == 11) {
            return 0.2;
        } else if (month == 3) {
            return 0.3;
        } else if (month == 10 || month == 2 || month == 1) {
            return -0.3;
        } else {
            return 0.0;
        }
    }
}