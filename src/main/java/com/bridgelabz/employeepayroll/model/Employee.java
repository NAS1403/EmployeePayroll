package com.bridgelabz.employeepayroll.model;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String name;
    public String gender;
    @ElementCollection
    @CollectionTable(name = "department", joinColumns = @JoinColumn(name = "id"))
    public List<String> department;
    public int salary;
    public LocalDate startDate;
    public String notes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee(int id, String name, String gender, int salary, LocalDate startDate, String notes, List<String> department) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.startDate = startDate;
        this.notes = notes;
        this.department = department;
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
        this.department = employeeDTO.getDepartment();
        this.gender = gender;
        this.startDate = startDate;
        this.notes = notes;
    }

    public List<String> getDepartment() {
        return department;
    }


    public void setDepartment(List<String> department) {
        this.department = department;
    }

    public Employee(EmployeeDTO employeeDTO){
        this.name = employeeDTO.getName();
        this.gender = employeeDTO.getGender();
        this.notes = employeeDTO.getNotes();
        this.startDate = employeeDTO.getStartDate();
        this.salary = employeeDTO.getSalary();
        this.department = employeeDTO.getDepartment();
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                ", startDate=" + startDate +
                ", notes='" + notes + '\'' +
                '}';
    }
}
