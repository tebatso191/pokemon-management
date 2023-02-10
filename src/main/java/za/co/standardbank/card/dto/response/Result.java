package za.co.standardbank.card.dto.response;

import com.google.gson.annotations.Expose;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Result {
    @JsonProperty("name")
    @Expose
    private String name;
    @JsonProperty("url")
    @Expose
    private String url;
}
