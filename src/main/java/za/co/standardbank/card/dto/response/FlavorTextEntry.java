
package za.co.standardbank.card.dto.response;

import com.google.gson.annotations.Expose;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlavorTextEntry {
    @JsonProperty("flavor_text")
    @Expose
    private String flavorText;
    @JsonProperty("language")
    @Expose
    private Language language;
    @JsonProperty("version")
    @Expose
    private Version version;
}
