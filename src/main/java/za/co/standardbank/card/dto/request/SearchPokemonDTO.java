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
public class SearchPokemonDTO {
    @Schema(description = "Search By PokemonName Field")
    @NotNull
    private String name;
}
