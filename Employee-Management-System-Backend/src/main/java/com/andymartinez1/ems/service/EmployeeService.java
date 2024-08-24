package com.andymartinez1.ems.service;

import com.andymartinez1.ems.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Long employeeId);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO updateEmployee(Long employeeID, EmployeeDTO updatedEmployee);

    void deleteEmployee(Long employeeId);
}
