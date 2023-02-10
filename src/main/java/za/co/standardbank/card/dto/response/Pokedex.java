
package za.co.standardbank.card.dto.response;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.fasterxml.jackson.annotation.JsonProperty;

@Generated("jsonschema2pojo")
public class Pokedex {
    @JsonProperty("name")
    @Expose
    private String name;
    @JsonProperty("url")
    @Expose
    private String url;
}
