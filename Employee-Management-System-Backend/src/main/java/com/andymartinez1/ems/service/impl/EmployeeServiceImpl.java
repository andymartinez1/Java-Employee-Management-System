package com.andymartinez1.ems.service.impl;

import com.andymartinez1.ems.dto.EmployeeDTO;
import com.andymartinez1.ems.entity.Employee;
import com.andymartinez1.ems.exception.ResourceNotFoundException;
import com.andymartinez1.ems.mapper.EmployeeMapper;
import com.andymartinez1.ems.repository.EmployeeRepository;
import com.andymartinez1.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    // Inject employee repository as a dependency
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        // Convert EmployeeDTO into Employee JPA entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        // Saves JPA object to database
        Employee savedEmployee = employeeRepository.save(employee);
        // Convert saved Employee JPA to EmployeeDTO to return to client
        return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with given id: " + employeeId));
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDTO(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with given id: " + employeeId));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with given id: " + employeeId));
        employeeRepository.deleteById(employeeId);
    }
}
