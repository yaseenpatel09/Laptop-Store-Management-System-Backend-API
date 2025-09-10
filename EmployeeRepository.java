package Employee.Employee_management_system.Repository;

import Employee.Employee_management_system.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
