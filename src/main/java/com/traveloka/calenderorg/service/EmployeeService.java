package com.traveloka.calenderorg.service;

import com.traveloka.calenderorg.entity.Employee;
import com.traveloka.calenderorg.repository.EmployeeRepository;
import com.traveloka.calenderorg.web.model.EmployeeDTO;
import com.traveloka.calenderorg.web.transformer.EmployeeConverter;
import org.springframework.stereotype.Service;

/**
 * @author badrikant.soni
 */
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeConverter employeeConverter;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeConverter employeeConverter) {
        this.employeeRepository = employeeRepository;
        this.employeeConverter = employeeConverter;
    }

    public Employee addEmployee(EmployeeDTO employeeDTO) {
        final Employee employee = employeeConverter.toEntity(employeeDTO);
        final Employee saveEmployee = employeeRepository.save(employee);
        return saveEmployee;
    }

    public Iterable<Employee> getAllEmployees() {
        final Iterable<Employee> employees = employeeRepository.findAll();
        return employees;
    }
}
