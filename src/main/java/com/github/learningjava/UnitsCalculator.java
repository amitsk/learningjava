package com.github.learningjava;


public class UnitsCalculator {

    public UnitsCalculator() {

    }

    public double celciusToFarenheit (double celcius) {

        return (celcius * (9.0 / 5.0)) + 32;
    }

    public double farenheitToCelcius (double farenheit) {

        return (farenheit - 32) * (5.0 / 9.0);
    }
}
