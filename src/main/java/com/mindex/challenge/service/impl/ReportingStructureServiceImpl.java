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

    private EmployeeRepository employeeRepository;

    private ReportingStructure reportingStructure;
    private Employee employee;

    @Autowired
    private ReportingStructureRepository ReportingStructureRepository;

    @Override
    public ReportingStructure create(String employeeId) {
        LOG.debug("Creating ReportingStructure for employeeId [{}]", employeeId);
        
        employee = employeeRepository.findByEmployeeId(employeeId);

        reportingStructure.setEmployee(employee);
        reportingStructure.setNumberOfReports();

        ReportingStructureRepository.insert(reportingStructure);

        return reportingStructure;
    }

    @Override
    public ReportingStructure read(String employeeId) {
        LOG.debug("Creating ReportingStructure with employeeId [{}]", employeeId);

        employee = employeeRepository.findByEmployeeId(employeeId);

        reportingStructure = ReportingStructureRepository.findByEmployee(employee);

        if (reportingStructure == null) {
            throw new RuntimeException("Invalid ReportingStructure with EmployeeId: " + employeeId);
        }

        return reportingStructure;
    }

    @Override
    public ReportingStructure update(String employeeId) {
        LOG.debug("Updating ReportingStructure for employeeId [{}]", employeeId);

        employee = employeeRepository.findByEmployeeId(employeeId);

        reportingStructure = ReportingStructureRepository.findByEmployee(employee);
        reportingStructure.setNumberOfReports();

        return ReportingStructureRepository.save(reportingStructure);
    }
}
