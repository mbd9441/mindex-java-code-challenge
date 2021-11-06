package com.mindex.challenge.service;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.data.Employee;

public interface ReportingStructureService {
    ReportingStructure create(Employee employee);
    ReportingStructure read(Employee employee);
    ReportingStructure update(Employee employee);
}
