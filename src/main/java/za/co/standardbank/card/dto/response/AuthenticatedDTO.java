package za.co.standardbank.card.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "A Response Object For Authentication")
public class AuthenticatedDTO {
    @Schema(description = "X Auth Token")
    private String token;
}
