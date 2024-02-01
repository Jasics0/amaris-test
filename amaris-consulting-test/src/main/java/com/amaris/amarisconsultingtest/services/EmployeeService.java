package com.amaris.amarisconsultingtest.services;

import com.amaris.amarisconsultingtest.utils.consumer.ApiConsumer;
import com.amaris.amarisconsultingtest.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final ApiConsumer apiConsumer;

    public List<Employee> getEmployees() {
        return apiConsumer.getAllEmployees()
                .stream()
                .peek(employee -> employee.setAnnualSalary(getSalaryAnnual(employee.getSalary())))
                .collect(Collectors.toList());
    }


    public Employee getEmployeeById(int id) {
        return apiConsumer.getAllEmployees()
                .stream()
                .filter(employee -> employee.getId() == id)
                .peek(employee -> employee.setAnnualSalary(getSalaryAnnual(employee.getSalary())))
                .findFirst()
                .orElse(null);
    }


    private double getSalaryAnnual(double salary) {
        return salary * 12;
    }

}
