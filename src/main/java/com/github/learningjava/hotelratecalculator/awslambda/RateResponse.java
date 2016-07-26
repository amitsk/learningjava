package com.github.learningjava.hotelratecalculator.awslambda;

/**
 * Created by amit on 7/25/16.
 */
public class RateResponse {
    private Double roomRate;

    public Double getRoomRate() {
        return roomRate;
    }

    public void setRoomRate(Double roomRate) {
        this.roomRate = roomRate;
    }
}
