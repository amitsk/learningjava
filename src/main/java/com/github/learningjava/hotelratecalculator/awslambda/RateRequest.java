package com.github.learningjava.hotelratecalculator.awslambda;

/**
 * Created by amit on 7/25/16.
 */
public class RateRequest {

    private String zipCode;
    private Integer month;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
}
