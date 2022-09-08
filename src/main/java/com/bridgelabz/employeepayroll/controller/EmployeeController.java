package com.bridgelabz.employeepayroll.controller;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.dto.ResponseDTO;
import com.bridgelabz.employeepayroll.service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/home")
public class EmployeeController {

    @Autowired
    EmployeeServiceInterface employeeService;

    /**
     * add employee to database
     * this is POST call
     * */
    @PostMapping("/addEmployee")
    public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
        ResponseDTO responseDTO = new ResponseDTO("Added",employeeService.addEmployee(employeeDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    /**
     * update employee in database by Id
     * this is PUT call
     * */
    @PutMapping("/updateEmployeeById/{id}")
    public ResponseEntity<ResponseDTO> updateEmployee(@Valid @RequestBody EmployeeDTO employeeDTO, @PathVariable int id) throws Exception {
        ResponseDTO responseDTO = new ResponseDTO("Updated",employeeService.updateEmployee(employeeDTO,id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * delete employee from database by Id
     * this is DELETE call
     * */
    @DeleteMapping("deleteEmployeeById/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int id) throws Exception {
        ResponseDTO responseDTO = new ResponseDTO("Updated",employeeService.deleteEmployee(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * gets employee from database by ID
     * this is GET call
     * */
    @GetMapping("getEmployeeById/{id}")
    public ResponseEntity<ResponseDTO> getEmployeeById(@PathVariable int id) throws Exception {
        ResponseDTO responseDTO = new ResponseDTO("Succeeded",employeeService.getEmployeeById(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * gets all employees from database
     * this is GET call
     * */
    @GetMapping("/getEmployees")
    public ResponseEntity<ResponseDTO> getEmployees() throws Exception {
        ResponseDTO responseDTO = new ResponseDTO("Succeeded",employeeService.getEmployees());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
