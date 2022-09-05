package com.bridgelabz.employeepayroll.controller;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.dto.ResponseDTO;
import com.bridgelabz.employeepayroll.service.EmployeeServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/home")
public class EmployeeController {
    EmployeeServiceInterface employeeService;

    @PostMapping("/addEmployee")
    public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
        ResponseDTO responseDTO = new ResponseDTO("Added",employeeService.addEmployee(employeeDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployeeById/{id}")
    public ResponseEntity<ResponseDTO> updateEmployee(@Valid @RequestBody EmployeeDTO employeeDTO, @PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO("Updated",employeeService.updateEmployee(employeeDTO,id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("deleteEmployeeById/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO("Updated",employeeService.deleteEmployee(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("getEmployeeById/{id}")
    public ResponseEntity<ResponseDTO> getEmployeeById(@PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO("Succeeded",employeeService.getEmployeeById(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getEmployees")
    public ResponseEntity<ResponseDTO> getEmployees(){
        ResponseDTO responseDTO = new ResponseDTO("Succeeded",employeeService.getEmployees());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
