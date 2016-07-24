package com.github.learningjava.hotelratecalculator;

import org.assertj.core.data.Offset;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;


public class DiscountRateServiceTest {
    @Test
    public void whenMonthis1or2or10() throws Exception {
        DiscountRateService classUnderTest = new DiscountRateService();
        assertThat(classUnderTest.getDiscountRateForMonth(1)).isCloseTo(-0.3, Offset.offset(0.01));

    }

    @Test
    public void whenMonthIsZero() throws Exception {
        DiscountRateService classUnderTest = new DiscountRateService();
        assertThat(classUnderTest.getDiscountRateForMonth(0)).isCloseTo(0.0, Offset.offset(0.00));

    }

    @Test
    public void whenMonthIsNegative() throws Exception {
        DiscountRateService classUnderTest = new DiscountRateService();
        assertThat(classUnderTest.getDiscountRateForMonth(-5)).isCloseTo(0.0, Offset.offset(0.00));

    }

    @Test
    public void whenMonthIsMoreThan12() throws Exception {
        DiscountRateService classUnderTest = new DiscountRateService();
        assertThat(classUnderTest.getDiscountRateForMonth(21)).isCloseTo(0.0, Offset.offset(0.00));

    }

    @Test
    public void whenMonthisBetween6and8() throws Exception {
        DiscountRateService classUnderTest = new DiscountRateService();
        assertThat(classUnderTest.getDiscountRateForMonth(8)).isCloseTo(0.5, Offset.offset(0.01));

    }

    @Test
    public void whenMonthis11or12() throws Exception {
        DiscountRateService classUnderTest = new DiscountRateService();
        assertThat(classUnderTest.getDiscountRateForMonth(12)).isCloseTo(0.2, Offset.offset(0.01));

    }

    @Test
    public void whenMonthIs3() throws Exception {
        DiscountRateService classUnderTest = new DiscountRateService();
        assertThat(classUnderTest.getDiscountRateForMonth(3)).isCloseTo(0.3, Offset.offset(0.01));

    }


}