package application.error.format;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

@AllArgsConstructor
public class ExceptionPrueba {
    private Timestamp fecha;
    private HttpStatus status;
    private String message;
}
