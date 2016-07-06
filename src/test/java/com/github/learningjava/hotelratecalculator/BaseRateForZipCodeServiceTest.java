package com.github.learningjava.hotelratecalculator;

import org.assertj.core.data.Offset;
import org.junit.Test;

import java.util.Currency;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 */
public class BaseRateForZipCodeServiceTest {
    @Test
    public void shouldReturnBaseRate97006(){
        BaseRateForZipCodeService classUnderTest = new BaseRateForZipCodeService(Currency.getInstance("USD"));
        assertThat(classUnderTest.getBaseRateForZipCode("97006")).isCloseTo(100.0, Offset.offset(0.001));

    }
    @Test
    public void shouldReturnBaseRate97007(){
        BaseRateForZipCodeService classUnderTest = new BaseRateForZipCodeService(Currency.getInstance("USD"));
        assertThat(classUnderTest.getBaseRateForZipCode("97007")).isCloseTo(130.0, Offset.offset(0.001));
    }

    @Test
    public void shouldReturnBaseRate97220(){
        BaseRateForZipCodeService classUnderTest = new BaseRateForZipCodeService(Currency.getInstance("USD"));
        assertThat(classUnderTest.getBaseRateForZipCode("97220")).isCloseTo(140.0, Offset.offset(0.001));
    }



    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowErrorForNull(){
        BaseRateForZipCodeService classUnderTest = new BaseRateForZipCodeService(Currency.getInstance("USD"));
        classUnderTest.getBaseRateForZipCode(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowErrorForDefault(){
        BaseRateForZipCodeService classUnderTest = new BaseRateForZipCodeService(Currency.getInstance("USD"));
        classUnderTest.getBaseRateForZipCode("kij90");
    }


}
