package com.amaris.amarisconsultingtest.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int id;
    @JsonAlias({"name", "employee_name"})
    private String name;
    @JsonAlias({"salary","employee_salary"})
    private double salary;
    private double annualSalary;
    @JsonAlias({"age","employee_age"})
    private String age;
    @JsonAlias({"profileImage","profile_image"})
    private String profileImage;
}
