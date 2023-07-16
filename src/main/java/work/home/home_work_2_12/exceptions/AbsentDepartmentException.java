package work.home.home_work_2_12.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AbsentDepartmentException extends RuntimeException {
    public AbsentDepartmentException(String message) {
        super(message);
    }
}
