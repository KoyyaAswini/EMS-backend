package com.EMS.ems.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EMS.ems.backend.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

}
