package com.mindex.challenge.controller;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.ReportingStructureService;
import com.mindex.challenge.service.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReportingStructureController {
    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class);    

    private Employee employee;

    @Autowired
    private ReportingStructureService reportingStructureService;
    private EmployeeService employeeService;

    @PostMapping("/reportingStructure")
    public ReportingStructure create(@RequestBody String employeeId) {
        LOG.debug("Received Reporting Structure create request for [{}]", employeeId);
        this.employee = employeeService.read(employeeId);

        return reportingStructureService.create(this.employee);
    }

    @GetMapping("/reportingStructure/{employeeId}")
    public ReportingStructure read(@PathVariable String employeeId) {
        LOG.debug("Received reportingStructure create request for employeeId [{}]", employeeId);

        return reportingStructureService.read(employeeService.read(employeeId));
    }

    @PutMapping("/reportingStructure/{employeeId}")
    public ReportingStructure update(@PathVariable String id, @RequestBody String employeeId) {
        LOG.debug("Received Reporting Structure edit request for employeeId [{}]", employeeId);

        return reportingStructureService.update(employeeService.read(employeeId));
    }
}
