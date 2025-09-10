package Employee.Employee_management_system.Service.impl;

import Employee.Employee_management_system.DTO.EmployeeDTO;
import Employee.Employee_management_system.Exeption.EmployeesExeption;
import Employee.Employee_management_system.Mapper.EmployeeMapper;
import Employee.Employee_management_system.Repository.EmployeeRepository;
import Employee.Employee_management_system.Service.EmployeeService;
import Employee.Employee_management_system.Entity.Employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

@RequiredArgsConstructor
public class Employeeimpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeDTO(long employeeId) {
      Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new EmployeesExeption("employee not found "+employeeId));
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> findAllEmployees() {
        List<Employee> employees=employeeRepository.findAll();
        return employees.stream().map((Employee)->EmployeeMapper.mapToEmployeeDTO(Employee))
                .collect(Collectors.toList());

    }
}