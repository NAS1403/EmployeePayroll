package com.bridgelabz.employeepayroll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class EmployeeDTO {

    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}$",message = "Not a Valid Name")
    public String name;
    public int salary;
    public String gender;
    public String notes;
    public LocalDate startDate;
    public List<String> department;
}
