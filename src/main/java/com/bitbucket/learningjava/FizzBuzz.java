package com.bitbucket.learningjava;

/**
 * Created by amit on 8/17/14.
 */
public class FizzBuzz {
    public String getFizzBuzz(int i){
        if ((i%3) == 0 && (i%5 == 0)){
            return "fizz buzz";
        }
        else if ((i%3) == 0){
            return "fizz";
        }
        else if ((i%5) == 0){
            return "buzz";
        }
        else
            return i + "";
    }
}
