package za.co.standardbank.card.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Schema(description = "A Request Object For Pokemon Details")
public class SearchPokemonRequest {
    @Schema(description = "Search By Name Field")
    @NotNull
    private String name;
}
