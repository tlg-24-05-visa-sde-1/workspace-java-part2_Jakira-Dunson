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
        employee = new SalariedEmployee("Nova", Date.valueOf("2017-07-18"));
        employee2 = new SalariedEmployee("Nova", Date.valueOf("2017-07-18"));
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(employee, employee2); //this does an .equals() check
    }
}