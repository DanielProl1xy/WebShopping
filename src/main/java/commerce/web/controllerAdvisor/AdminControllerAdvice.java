package commerce.web.controllerAdvisor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdminControllerAdvice {
    
    @ExceptionHandler(value = SecurityException.class)
    public ResponseEntity<?> onSecurityException(SecurityException exception) {
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
