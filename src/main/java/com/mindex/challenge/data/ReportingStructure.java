package com.mindex.challenge.data;

public class ReportingStructure{
    private Employee employee;
    private Integer numberOfReports;

    public ReportingStructure(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee(){
        return this.employee;
    }

    public Integer getNumberOfReports() {
        return this.numberOfReports;
    }

    public void setNumberOfReports(Integer numberOfReports) {
        this.numberOfReports = numberOfReports;
    }

}
