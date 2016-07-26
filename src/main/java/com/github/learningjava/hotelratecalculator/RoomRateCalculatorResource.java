package com.github.learningjava.hotelratecalculator;

import com.github.learningjava.hotelratecalculator.RoomRateCalculator.RoomRateInput;
import spark.Route;
import spark.route.RouteOverview;

import java.util.Currency;

import static java.lang.Integer.parseInt;
import static spark.Spark.*;

/**
 * Created by amit on 7/25/16.
 */
public class RoomRateCalculatorResource {

    private static RoomRateCalculator roomRateCalculator  = new RoomRateCalculator(
            new BaseRateForZipCodeService(Currency.getInstance("USD")),
            new DiscountRateService(),
            new TaxRateByZipCodeService());

    public static void main(String[] args) {
        // matches "GET /hello/foo" and "GET /hello/bar"
        // request.params(":name") is 'foo' or 'bar'
        get("/roomrate/:zipcode/:month", (request, response) -> {
            String zipCode = request.params(":zipcode");
            String month = request.params(":month");

            if(  zipCode == null || zipCode.isEmpty() || month == null || month.isEmpty()) {
                response.status(400);
                return response;
            }
            else {
                return roomRateCalculator.getTotalRoomRate(new RoomRateInput(zipCode, parseInt(month)));
            }

        });
    }
}
