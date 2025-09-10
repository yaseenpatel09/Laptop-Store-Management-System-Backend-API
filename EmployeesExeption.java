package Employee.Employee_management_system.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeesExeption extends RuntimeException {

    public EmployeesExeption(String message){
        super(message);
    }
}
