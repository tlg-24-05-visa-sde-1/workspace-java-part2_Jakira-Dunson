package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    private HourlyEmployee hourlyEmployee;

    @Before
    public void setUp()  {
        hourlyEmployee = new HourlyEmployee("Nora", Date.valueOf("2010-1-10"),25.0,35.0);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(218.75, hourlyEmployee.payTaxes(), 0.001);
    }
}