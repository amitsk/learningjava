package com.github.learningjava;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by amit on 9/10/14.
 */
public class UnitsCalculatorTest {

    @Test
    public void shouldConvertCelciusToFarenheit(){
        UnitsCalculator unitsCalculator = new UnitsCalculator();
        assertThat(unitsCalculator.celciusToFarenheit(5.0)).isCloseTo(41.0, Offset.offset(0.001));

    }

     @Test
        public void shouldConvertFarenheitToCelcius(){
        UnitsCalculator unitsCalculator = new UnitsCalculator();
        assertThat(unitsCalculator.farenheitToCelcius(212.0)).isCloseTo(100.0, Offset.offset(0.001));

    }
}
