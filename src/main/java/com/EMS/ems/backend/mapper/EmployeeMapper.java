package com.EMS.ems.backend.mapper;

import com.EMS.ems.backend.dto.Employeedto;
import com.EMS.ems.backend.entity.Employee;

public class EmployeeMapper {

    public static Employeedto mapToEmployeeDto(Employee employee) {
        return new Employeedto(
                employee.getId(),     
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );      
    }

    public static Employee mapToEmployee(Employeedto employeedto) {
        return new Employee(
                employeedto.getId(),  
                employeedto.getFirstName(),
                employeedto.getLastName(),
                employeedto.getEmail()
        );      
    }
}
