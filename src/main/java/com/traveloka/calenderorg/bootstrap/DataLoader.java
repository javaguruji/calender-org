package com.traveloka.calenderorg.bootstrap;

import com.traveloka.calenderorg.entity.Employee;
import com.traveloka.calenderorg.entity.Meeting;
import com.traveloka.calenderorg.repository.EmployeeRepository;
import com.traveloka.calenderorg.repository.MeetingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author badrikant.soni
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final MeetingRepository meetingRepository;

    public DataLoader(EmployeeRepository employeeRepository, MeetingRepository meetingRepository) {
        this.employeeRepository = employeeRepository;
        this.meetingRepository = meetingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading employee data....");
        loadEmployeeObject();
        loadMeetingObject();
        System.out.println("employee data is successfully loaded");
    }

    private void loadMeetingObject() {
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        employee.setName("test");
        employees.add(employee);

        if (meetingRepository.count() == 0) {
            meetingRepository.save(Meeting.builder()
                    .meetingRoomName("Room1")
                    .empId(1L)
                    .build());

            meetingRepository.save(Meeting.builder()
                    .meetingRoomName("Room2")
                    .empId(2L)
                    .build());
        }
    }

    private void loadEmployeeObject() {

        if (employeeRepository.count() == 0) {
            employeeRepository.save(Employee.builder()
                    .dept("IT")
                    .name("Badri")
                    .id(100L)
                    .build());
            employeeRepository.save(Employee.builder()
                    .dept("IT")
                    .name("Shri")
                    .id(101L)
                    .build());
        }
    }
}
