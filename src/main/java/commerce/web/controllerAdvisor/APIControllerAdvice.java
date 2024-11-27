package commerce.web.controllerAdvisor;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import commerce.web.exception.ItemNotFoundException;

@RestControllerAdvice
public class APIControllerAdvice {
    
    @ExceptionHandler(value = {ItemNotFoundException.class})
    public ResponseEntity<?> onItemNotFoundException(ItemNotFoundException exception) {
        HashMap<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", -1);
        responseBody.put("message", exception.getMessage());
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity<?> onMissingServletRequestParameterException(MissingServletRequestParameterException exception) {
        HashMap<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", -1);
        responseBody.put("message", exception.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}
