package com.traveloka.calenderorg.repository;

import com.traveloka.calenderorg.entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author badrikant.soni
 */
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
}
