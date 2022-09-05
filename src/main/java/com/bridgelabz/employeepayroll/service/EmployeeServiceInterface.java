package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceInterface {
    Employee addEmployee(EmployeeDTO employeeDTO);
    Employee updateEmployee(EmployeeDTO employeeDTO,int id);
    String deleteEmployee(int id);
    Optional<Employee> getEmployeeById(int id);
    List<Employee> getEmployees();
}
