package com.github.learningjava.hotelratecalculator;


import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class RoomRateCalculatorTest {

    @Test
    public void shouldReturnCorrectRate() {
        TaxRateByZipCodeService taxRateByZipCodeService = mock(TaxRateByZipCodeService.class);

        when(taxRateByZipCodeService.getTaxPercentForZipCode(anyString())).thenReturn(10.0);

        BaseRateForZipCodeService baseRateForZipCodeService = mock(BaseRateForZipCodeService.class);

        when(baseRateForZipCodeService.getBaseRateForZipCode(anyString())).thenReturn(100.0);

        DiscountRateService discountRateService = mock(DiscountRateService.class);

        when(discountRateService.getDiscountRateForMonth(anyInt())).thenReturn(0.10);

        RoomRateCalculator roomRateCalculator = new RoomRateCalculator(baseRateForZipCodeService, discountRateService, taxRateByZipCodeService);
        assertThat(roomRateCalculator.getTotalRoomRate(new RoomRateCalculator.RoomRateInput("97006", 1))).isCloseTo(120.0, Offset.offset(0.01));


    }

}
