package application.error;

import application.error.format.ExceptionPrueba;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestControllerAdvice
public class Exceptions {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionPrueba> exception(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionPrueba(Timestamp.valueOf(LocalDateTime.now()),
                        HttpStatus.BAD_REQUEST,
                        ex.getMessage()));
    }
}
