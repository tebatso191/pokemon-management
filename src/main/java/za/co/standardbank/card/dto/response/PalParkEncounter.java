
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
public class PalParkEncounter {
    @JsonProperty("area")
    @Expose
    private Area area;
    @JsonProperty("base_score")
    @Expose
    private Integer baseScore;
    @JsonProperty("rate")
    @Expose
    private Integer rate;
}
