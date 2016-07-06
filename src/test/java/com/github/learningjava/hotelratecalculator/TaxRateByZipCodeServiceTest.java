package com.github.learningjava.hotelratecalculator;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 */
public class TaxRateByZipCodeServiceTest {
    @Test
    public void shouldReturnTaxRate97006(){
        TaxRateByZipCodeService classUnderTest = new TaxRateByZipCodeService();
        assertThat(classUnderTest.getTaxPercentForZipCode("97006")).isCloseTo(11.0, Offset.offset(0.001));

    }
    @Test
    public void shouldReturnTaxRate97007() {
        TaxRateByZipCodeService classUnderTest = new TaxRateByZipCodeService();
        assertThat(classUnderTest.getTaxPercentForZipCode("97007")).isCloseTo(12.6, Offset.offset(0.001));
    }

    @Test
    public void shouldReturnTaxRate97220() {
        TaxRateByZipCodeService classUnderTest = new TaxRateByZipCodeService();
        assertThat(classUnderTest.getTaxPercentForZipCode("97220")).isCloseTo(11.3, Offset.offset(0.001));
    }



    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowErrorForNull(){
        TaxRateByZipCodeService classUnderTest = new TaxRateByZipCodeService();
        classUnderTest.getTaxPercentForZipCode(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowErrorForDefault(){
        TaxRateByZipCodeService classUnderTest = new TaxRateByZipCodeService();
        classUnderTest.getTaxPercentForZipCode("asjfg");
    }
}
