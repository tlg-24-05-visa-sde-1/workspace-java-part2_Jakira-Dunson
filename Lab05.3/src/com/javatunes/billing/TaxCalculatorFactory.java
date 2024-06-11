package com.javatunes.billing;

public class TaxCalculatorFactory {

    public static TaxCalculator getTaxCalculator(Location location) {
        TaxCalculator calculator = null;

        switch(location) {
            case ONLINE:
                calculator = new OnlineTax();
                break;
            case USA:
                calculator = new USATax();
                break;
            case EUROPE:
                calculator = new EuropeTax();
                break;
        }
        return calculator;
    }
}
