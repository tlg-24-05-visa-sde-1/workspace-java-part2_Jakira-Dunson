package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {

    //business object(s) under test
    private SalariedEmployee salEmp;

    @Before
    public void setUp()  {
        salEmp = new SalariedEmployee("Jakira", Date.valueOf("2024-05-07"), 2500.0);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(750.0, salEmp.payTaxes(), .001);
    }
}