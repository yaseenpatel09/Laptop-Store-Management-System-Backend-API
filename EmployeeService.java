package Employee.Employee_management_system.Service;

import Employee.Employee_management_system.DTO.EmployeeDTO;


import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee
            (EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeDTO(long employeeDTO);

    List<EmployeeDTO> findAllEmployees();
}
