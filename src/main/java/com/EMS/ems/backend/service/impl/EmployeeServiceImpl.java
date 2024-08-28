package com.EMS.ems.backend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.EMS.ems.backend.dto.Employeedto;
import com.EMS.ems.backend.entity.Employee;
import com.EMS.ems.backend.exception.ResourceNotFoundException;
import com.EMS.ems.backend.mapper.EmployeeMapper;
import com.EMS.ems.backend.repository.EmployeeRepository;
import com.EMS.ems.backend.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employeedto createEmployee(Employeedto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

	@Override
	public Employeedto getEmployeeById(Long employeeid) {
		Employee employee=employeeRepository.findById(employeeid)
				.orElseThrow(()->
				new ResourceNotFoundException("Employee doesnt exist with i:"+employeeid)
				);
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<Employeedto> getAllEmployees() {
		List<Employee> employees=employeeRepository.findAll();
		
		return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public Employeedto updateEmployee(Long employeeid, Employeedto updateEmployee) {
		Employee employee=employeeRepository.findById(employeeid).orElseThrow(
				()->new ResourceNotFoundException("Employee not exist with given id:"+employeeid));
		employee.setFirstName(updateEmployee.getFirstName());
		employee.setLastName(updateEmployee.getLastName());
		employee.setEmail(updateEmployee.getEmail());
		Employee updatedEmployee=employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
	}

	@Override
	public void deleteEmployee(Long employeeid) {
		employeeRepository.findById(employeeid).orElseThrow(
				()->new ResourceNotFoundException("Employee not exist with given id:"+employeeid));
		 employeeRepository.deleteById(employeeid);
		
	}
}
