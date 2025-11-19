package kaziupl.satisfactoryplanner.handlers;


import com.example.satisfactoryplanner.model.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import kaziupl.satisfactoryplanner.errors.ResourceNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ErrorResponse handleResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
        ErrorResponse error = new ErrorResponse();
        error.setStatus(404);
        error.setTitle("Resource not found");
        error.setDetail(e.getMessage());
        error.setInstance(request.getRequestURL().toString());

        return error;
    }
}
