package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.ReportingStructureRepository;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private ReportingStructureRepository reportingStructureRepository;
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ReportingStructure read(String employeeId) {
        LOG.debug("Getting ReportingStructure for employeeId [{}]", employeeId);

        Employee employee = employeeRepository.findByEmployeeId(employeeId);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + employeeId);
        }

        ReportingStructure reportingStructure = new ReportingStructure(employee);
        reportingStructure.setNumberOfReports(getNumberOfReports(employee));

        return reportingStructure;
    }

    private Integer getNumberOfReports(Employee employee){
        Integer numberOfReports = 0;
        if(employee.getDirectReports() != null ){
            numberOfReports += employee.getDirectReports().size();
            for (Employee emp : employee.getDirectReports()){
                LOG.debug(emp.getEmployeeId());
                emp = employeeRepository.findByEmployeeId(emp.getEmployeeId());
                numberOfReports += getNumberOfReports(emp);
            }
        }
        return numberOfReports;
    }
}
