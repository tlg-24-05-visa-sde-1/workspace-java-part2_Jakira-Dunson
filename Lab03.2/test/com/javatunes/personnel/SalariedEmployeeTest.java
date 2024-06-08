package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {

    //business object(s) under test
    private SalariedEmployee salariedEmployee;

    @Before
    public void setUp()  {
        salariedEmployee = new SalariedEmployee("Jakira", Date.valueOf("2024-05-07"), 2500.0);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(750.0, salariedEmployee.payTaxes(), .001);
    }

    @Test
    public void testPay() {
        assertEquals(2500.0, salariedEmployee.pay(), .001);

    }
}