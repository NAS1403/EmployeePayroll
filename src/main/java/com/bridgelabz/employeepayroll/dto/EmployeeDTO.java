package com.bridgelabz.employeepayroll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}$",message = "Not a Valid Name")
    private String name;
    private int salary;
}
