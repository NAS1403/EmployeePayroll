package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.model.Employee;
import com.bridgelabz.employeepayroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeServiceInterface{

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee(employeeDTO);
      return  employeeRepository.save(employee);
    }

    public Employee updateEmployee(EmployeeDTO employeeDTO,int id){
        Employee employee = employeeRepository.findById(id).get();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        return  employeeRepository.save(employee);
    }

    public String deleteEmployee(int id){
        employeeRepository.deleteById(id);
        return "Delete SuccessFull";
    }

    public Optional<Employee> getEmployeeById(int id){
       return employeeRepository.findById(id);
    }

    public List<Employee> getEmployees() {
       return employeeRepository.findAll();
    }
}
