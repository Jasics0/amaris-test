package com.amaris.amarisconsultingtest.services;

import com.amaris.amarisconsultingtest.services.interfaces.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void testGetEmployees() throws InterruptedException {
        assert (!employeeService.getEmployees().isEmpty());
    }

    @Test
    void testGetEmployeeById() throws InterruptedException {
        assert (employeeService.getEmployeeById(1) != null);
    }

    @Test
    void testAnnualSalary() throws InterruptedException {
        assert(employeeService.getEmployeeById(1).getAnnualSalary() !=0);
    }

}
