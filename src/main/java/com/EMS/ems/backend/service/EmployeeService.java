package com.EMS.ems.backend.service;

import java.util.List;

import com.EMS.ems.backend.dto.Employeedto;

public interface EmployeeService {
	Employeedto createEmployee(Employeedto employeeDto);
    Employeedto getEmployeeById(Long employeeid);
    List<Employeedto> getAllEmployees();
    Employeedto updateEmployee(Long employeeid,Employeedto updateEmployee);
    void deleteEmployee(Long employeeid);
}
