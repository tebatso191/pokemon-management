
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
public class Variety {
    @JsonProperty("is_default")
    @Expose
    private Boolean isDefault;
    @JsonProperty("pokemon")
    @Expose
    private Pokemon pokemon;
}
