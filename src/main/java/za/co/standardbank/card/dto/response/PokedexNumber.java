
package za.co.standardbank.card.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PokedexNumber {
    @JsonProperty("entry_number")
    @Expose
    private Integer entryNumber;
    @JsonProperty("pokedex")
    @Expose
    private Pokedex pokedex;
}
