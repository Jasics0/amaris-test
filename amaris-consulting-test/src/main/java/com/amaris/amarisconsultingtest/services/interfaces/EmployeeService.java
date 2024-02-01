package com.amaris.amarisconsultingtest.services.interfaces;

import com.amaris.amarisconsultingtest.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees() throws InterruptedException;

    Employee getEmployeeById(int id) throws InterruptedException;
}
