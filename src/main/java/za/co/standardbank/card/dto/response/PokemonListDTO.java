package za.co.standardbank.card.dto.response;

import com.google.gson.annotations.Expose;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PokemonListDTO {
    @JsonProperty("count")
    @Expose
    private Integer count;
    @JsonProperty("next")
    @Expose
    private String next;
    @JsonProperty("previous")
    @Expose
    private Object previous;
    @JsonProperty("results")
    @Expose
    private List<Result> results;
}
