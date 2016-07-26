package com.github.learningjava.hotelratecalculator.awslambda;


import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.github.learningjava.hotelratecalculator.BaseRateForZipCodeService;
import com.github.learningjava.hotelratecalculator.DiscountRateService;
import com.github.learningjava.hotelratecalculator.RoomRateCalculator;
import com.github.learningjava.hotelratecalculator.RoomRateCalculator.RoomRateInput;
import com.github.learningjava.hotelratecalculator.TaxRateByZipCodeService;

import java.util.Currency;

import static java.lang.Integer.parseInt;

public class RateCalculatorFunction  implements RequestHandler<RateRequest, RateResponse> {
    private  RoomRateCalculator roomRateCalculator  = new RoomRateCalculator(
            new BaseRateForZipCodeService(Currency.getInstance("USD")),
            new DiscountRateService(),
            new TaxRateByZipCodeService());

    @Override
    public RateResponse handleRequest(RateRequest input, Context context) {
        RateResponse rateResponse = new RateResponse();
        rateResponse.setRoomRate(roomRateCalculator.getTotalRoomRate(new RoomRateInput(
                input.getZipCode(), input.getMonth())));

        return new RateResponse();
    }
}
