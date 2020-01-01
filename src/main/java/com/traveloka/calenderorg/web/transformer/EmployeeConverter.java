package com.traveloka.calenderorg.web.transformer;

import com.traveloka.calenderorg.entity.Employee;
import com.traveloka.calenderorg.web.model.EmployeeDTO;
import org.springframework.stereotype.Component;

/**
 * @author badrikant.soni
 */
@Component
public class EmployeeConverter implements Converter<EmployeeDTO, Employee> {

    @Override
    public EmployeeDTO toDTO(Employee employee) {
        return new EmployeeDTO();
    }

    @Override
    public Employee toEntity(EmployeeDTO employeeDTO) {
        return Employee.builder()
                .name(employeeDTO.getName())
                .dept(employeeDTO.getDept())
                .build();
    }
}
