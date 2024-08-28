package com.EMS.ems.backend.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EMS.ems.backend.dto.Employeedto;
//import com.EMS.ems.backend.entity.Employee;
import com.EMS.ems.backend.service.EmployeeService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/ems")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	//add employee restAPI
	@PostMapping
	public ResponseEntity<Employeedto> createEmployee(@RequestBody Employeedto employeeDto){
		Employeedto savedEmployee=employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
	}
	
	//get employee restAPI
	@GetMapping("{id}")
	public ResponseEntity<Employeedto> getEmployeeById(@PathVariable("id") Long employeeId){
		Employeedto employeeDto=employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeDto);
		
	}
	
	//get all employees restAPI
	@GetMapping
	public ResponseEntity<List<Employeedto>> getAllEmployees(){
		List<Employeedto> employees=employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}

	//update employee restAPI
	@PutMapping("{id}")
	public ResponseEntity<Employeedto> updateEmployee(@PathVariable("id") Long employeeid,@RequestBody Employeedto updateEmployee){
		Employeedto employeeDto=employeeService.updateEmployee(employeeid, updateEmployee);
		return ResponseEntity.ok(employeeDto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeid){
		employeeService.deleteEmployee(employeeid);
		return ResponseEntity.ok("EMPLOYEE deleted successfully!");
	}
}
