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
        salEmp = new SalariedEmployee("Jakira", Date.valueOf("2024-05-07"), 4500.5);
    }

    @Test
    public void testPayTaxes() {
        salEmp.payTaxes();
    }
}