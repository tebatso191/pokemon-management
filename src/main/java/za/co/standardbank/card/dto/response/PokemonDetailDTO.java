package za.co.standardbank.card.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "A Response Object For Pokemon Details")
public class PokemonDetailDTO extends CommonDTO {
    @Schema(description = "Call Status Field")
    private Boolean test;
}
