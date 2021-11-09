package com.mindex.challenge.data;

public class ReportingStructure{
    private Employee employee;
    private Integer numberOfReports;

    public ReportingStructure() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getNumberOfReports() {
        this.setNumberOfReports();
        return this.numberOfReports;
    }

    public void setNumberOfReports() {
        this.numberOfReports = this.employee.getDirectReports().size();
    }

}
