package com.javatunes.billing;

public class TaxCalculatorFactory {

    public static TaxCalculator getTaxCalculator(Location location) {
        return switch (location) {
            //Switch expression
            //this basically states to return which ever matches
            case ONLINE -> new OnlineTax();
            case USA -> new USATax();
            case EUROPE -> new EuropeTax();
        };

        /*
        Early return version, no need for breaks
        switch (location) {
            case ONLINE:
                return new OnlineTax();
            case USA:
                return new USATax();
            case EUROPE:
                return new EuropeTax();
        }
        return null;
         */
        /*
        (old school Switch)
        switch(location) {
            case ONLINE:
                calculator = new OnlineTax();
                break;
            case USA:
                calculator = new USATax();
                break;
            case EUROPE:
                calculator = new EuropeTax();
        }
        return calculator;
         */
    }
}
