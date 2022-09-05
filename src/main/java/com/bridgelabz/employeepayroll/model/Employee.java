package com.bridgelabz.employeepayroll.model;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
public class Employee {
    public int id;
    public String name;
    public String gender;
    public int salary;
    public LocalDate startDate;
    public String notes;

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee(int id, String name, String gender, int salary, LocalDate startDate, String notes) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.startDate = startDate;
        this.notes = notes;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Employee(EmployeeDTO employeeDTO,String gender,LocalDate startDate, String notes){
        this.name = employeeDTO.getName();
        this.salary = employeeDTO.getSalary();
        this.gender = gender;
        this.startDate = startDate;
        this.notes = notes;
    }

    public Employee(EmployeeDTO employeeDTO){
        this.name = employeeDTO.getName();
        this.salary = employeeDTO.getSalary();
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

}
