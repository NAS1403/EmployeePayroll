package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.email.EmailService;
import com.bridgelabz.employeepayroll.exception.CustomException;
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

    @Autowired
    EmailService emailService;

    public Employee addEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee(employeeDTO);
        emailService.sendEmail(employeeDTO.getEmail(),"Employee added","Hello "+employeeDTO.getName()+" your employee record was added successfully");
      return  employeeRepository.save(employee);
    }

    public Employee updateEmployee(EmployeeDTO employeeDTO,int id){
        if(employeeRepository.findById(id).isPresent()) {
            Employee employee = employeeRepository.findById(id).get();
            employee.setName(employeeDTO.getName());
            employee.setSalary(employeeDTO.getSalary());
            return employeeRepository.save(employee);
        }
        else{
            throw new CustomException("Employee by ID "+id+" is not present");
        }
    }

    public String deleteEmployee(int id){
        if(employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return "Delete SuccessFull";
        }
        else
            throw new CustomException("Employee by ID "+id+" is not present");
    }

    public Optional<Employee> getEmployeeById(int id){
        if(employeeRepository.findById(id).isPresent()) {
            return employeeRepository.findById(id);
        }
        else
            throw new CustomException("Employee by ID "+id+" is not present");
    }

    public List<Employee> getEmployees(){
        if(!employeeRepository.findAll().isEmpty()){
       return employeeRepository.findAll();
        }
        else
            throw new CustomException("No employee in database to display");
    }
}
