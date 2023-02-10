
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
public class Language {
    @JsonProperty("name")
    @Expose
    private String name;
    @JsonProperty("url")
    @Expose
    private String url;
}
