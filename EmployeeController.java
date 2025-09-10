package Employee.Employee_management_system.Controller;

import Employee.Employee_management_system.DTO.EmployeeDTO;
import Employee.Employee_management_system.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Build Add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDto) {
        EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDTO employeeDTO = employeeService.getEmployeeDTO(employeeId);
        return ResponseEntity.ok(employeeDTO);
    }


    @GetMapping("allEmployees")

    public ResponseEntity<List<EmployeeDTO>> findAllEmployees(){
       List<EmployeeDTO> employeesDto=  employeeService.findAllEmployees();
       return ResponseEntity.ok(employeesDto);
    }

}
