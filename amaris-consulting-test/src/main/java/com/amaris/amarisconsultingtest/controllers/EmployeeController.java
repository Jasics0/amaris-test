package com.amaris.amarisconsultingtest.controllers;

import com.amaris.amarisconsultingtest.controllers.responses.ResponseDTO;
import com.amaris.amarisconsultingtest.model.Employee;
import com.amaris.amarisconsultingtest.services.interfaces.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping()
    public ResponseEntity<ResponseDTO<List<Employee>>> getAllEmployees() throws InterruptedException {
        return ResponseEntity.ok(new ResponseDTO<>(employeeService.getEmployees(), "Employees found"));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDTO<Employee>> getEmployeeById(@PathVariable int id) throws InterruptedException {
        return ResponseEntity.ok(new ResponseDTO<>(employeeService.getEmployeeById(id), "Employee info"));
    }



}
