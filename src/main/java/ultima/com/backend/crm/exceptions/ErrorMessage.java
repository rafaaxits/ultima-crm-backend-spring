package ultima.com.backend.crm.exceptions;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ErrorMessage {
    private int statusCode;
    private LocalDateTime timestamp;

    private String message;
}
