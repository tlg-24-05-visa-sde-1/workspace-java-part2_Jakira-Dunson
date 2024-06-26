/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SalariedEmployee extends Employee {
    private Double salary;

    protected SalariedEmployee() {
    }

    protected SalariedEmployee(String name, Date hireDate) {
        super(name, hireDate);
    }

    protected SalariedEmployee(String name, Date hireDate, Double salary) {
        this(name, hireDate);
        setSalary(salary);
    }

    public Double getSalary() {
        return this.salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": name=" + getName() + ", hireDate=" + getHireDate() +
                ", salary=" + getSalary();
    }
}