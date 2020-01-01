package com.traveloka.calenderorg.web.controller;

import com.traveloka.calenderorg.entity.Employee;
import com.traveloka.calenderorg.service.EmployeeService;
import com.traveloka.calenderorg.web.model.EmployeeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author badrikant.soni
 */
@RestController
@RequestMapping("/emp")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addNewEmployee(@RequestBody EmployeeDTO employee) {
        final Employee addEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<Employee>(addEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<Iterable<Employee>> listEmployees() {
        final Iterable<Employee> allEmployees = employeeService.getAllEmployees();
        return new ResponseEntity<Iterable<Employee>>(allEmployees, HttpStatus.OK);
    }
}
