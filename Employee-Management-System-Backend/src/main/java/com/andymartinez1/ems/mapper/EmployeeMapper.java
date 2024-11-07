package com.andymartinez1.ems.mapper;

import com.andymartinez1.ems.dto.EmployeeDTO;
import com.andymartinez1.ems.entity.Employee;

public class EmployeeMapper {

    // Map Employee entity to EmployeeDTO
    public  static EmployeeDTO mapToEmployeeDTO(Employee employee){
        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    // Map EmployeeDTO to Employee entity
    public static Employee mapToEmployee(EmployeeDTO employeeDTO){
        return new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail()
        );
    }
}
