package com.mindex.challenge.data;

import java.time.LocalDate;

public class Compensation {
    private String employeeId;
    private Integer salary;
    private LocalDate effectiveDate;

    public Compensation() {
    }

    public void setEmployeeId(String employeeId){
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public Integer getSalary(){
        return this.salary;
    }

    public LocalDate getEffectiveDate(){
        return this.effectiveDate;
    }

    public void setSalary(Integer salary){
        this.salary = salary;
    }

    public void setEffectiveDate(LocalDate effectiveDate){
        this.effectiveDate = effectiveDate;
    }

}
