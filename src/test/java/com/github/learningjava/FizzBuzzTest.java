package com.github.learningjava;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

/**
 * Created by amit on 8/18/14.
 */
public class FizzBuzzTest {
    @Test
    public void shouldReturnFizzBuzz (){
        FizzBuzz classUnderTest = new FizzBuzz();
        assertThat(classUnderTest.getFizzBuzz(15)).isEqualTo("fizz buzz");

    }
    @Test
    public void shouldReturnFizz (){
        FizzBuzz classUnderTest = new FizzBuzz();
        assertThat(classUnderTest.getFizzBuzz(3)).isEqualTo("fizz");

    }
    @Test
    public void shouldReturnBuzz (){
        FizzBuzz classUnderTest = new FizzBuzz();
        assertThat(classUnderTest.getFizzBuzz(5)).isEqualTo("buzz");

    }
    @Test
    public void shouldReturnNumber (){
        FizzBuzz classUnderTest = new FizzBuzz();
        assertThat(classUnderTest.getFizzBuzz(7)).isEqualTo("7");

    }

}
