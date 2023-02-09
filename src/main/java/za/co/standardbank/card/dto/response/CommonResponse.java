package za.co.standardbank.card.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CommonResponse {
    private Boolean success;
    private String message;
    private int code;
    private HttpStatus httpStatus;
    private String type;
}
