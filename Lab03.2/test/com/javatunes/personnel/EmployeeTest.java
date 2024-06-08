package com.javatunes.personnel;


import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class EmployeeTest {
    private  Employee employee; 
    private  Employee employee2;

    @Before
    public void setUp() throws Exception {
        employee = new SalariedEmployee("Nova", Date.valueOf("2017-01-01"));
        employee2 = new SalariedEmployee("Nova", Date.valueOf("2017-01-01"));
    }
    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate() {
        employee2.setName("Kira");
        assertNotEquals(employee, employee2);
        assertFalse(employee.equals(employee2));
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate() {
       employee2.setHireDate(Date.valueOf("2016-11-22"));
       assertNotEquals(employee, employee2);
       assertFalse(employee.equals(employee2));
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(employee, employee2); //this does an .equals() check
        assertTrue(employee.equals(employee2)); //alternative assertion
    }
}