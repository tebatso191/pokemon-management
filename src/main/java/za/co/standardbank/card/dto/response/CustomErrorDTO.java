package za.co.standardbank.card.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "A Custom Error Response Object For The Project.")
public class CustomErrorDTO extends CommonDTO {
    @Schema(description = "Log Level")
    private String level;
}
