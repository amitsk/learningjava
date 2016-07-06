package com.github.learningjava.hotelratecalculator;

/**
 * Created by amit on 9/11/14.
 */

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.number.IsCloseTo.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(DataProviderRunner.class)
public class RoomRateCalculatorTest {

    @Test
    @UseDataProvider("dataProviderMonth")
    public void shouldReturnCorrectRate( int month, double expectedRate){
        TaxRateByZipCodeService taxRateByZipCodeService = mock(TaxRateByZipCodeService.class);

        when(taxRateByZipCodeService.getTaxPercentForZipCode(anyString())).thenReturn(10.0);

        BaseRateForZipCodeService baseRateForZipCodeService = mock(BaseRateForZipCodeService.class);

        when(baseRateForZipCodeService.getBaseRateForZipCode(anyString())).thenReturn(100.0);

        RoomRateCalculator roomRateCalculator = new RoomRateCalculator(baseRateForZipCodeService,taxRateByZipCodeService);
        assertThat(roomRateCalculator.getTotalRoomRate("97006", month), closeTo(expectedRate, 0.01));


    }


    @DataProvider
    public static Object[][] dataProviderMonth() {
        // @formatter:off
        return new Object[][] {
                { 1, 80.0 },
                { 2, 80.0 },
                { 3, 140.0 },
                { 4, 110.0 },
                { 5, 110.0 },
                { 6, 160.0 },
                { 7, 160.0},
                { 8, 160.0 },
                { 9, 110.0 },
                { 10, 80.0 },
                { 11, 130.0 },
                { 12, 130.0},
                /* ... */
        };
        // @formatter:on
    }
}
