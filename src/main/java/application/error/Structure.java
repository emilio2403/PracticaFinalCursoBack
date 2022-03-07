package application.error;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Structure {

    private HttpStatus status;
    private LocalDateTime time;
    private String message;

    public Structure(HttpStatus notFound, String message) {
        this.status = notFound;
        this.message = message;
        this.time = LocalDateTime.now();
    }
}
