package za.co.standardbank.card.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonDTO {
    private boolean success;
    private String message;
    private int status;
    private String error;
    private String type;
}
