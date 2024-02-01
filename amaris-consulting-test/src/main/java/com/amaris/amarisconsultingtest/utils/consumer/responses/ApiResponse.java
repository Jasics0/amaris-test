package com.amaris.amarisconsultingtest.utils.consumer.responses;

import com.amaris.amarisconsultingtest.model.Employee;
import lombok.Data;

import java.util.List;

@Data
public class ApiResponse {
    private String status;
    private List<Employee> data;
}
