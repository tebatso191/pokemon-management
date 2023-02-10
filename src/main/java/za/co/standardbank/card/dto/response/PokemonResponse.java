
package za.co.standardbank.card.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PokemonResponse {
    @JsonProperty("base_happiness")
    @Expose
    private Integer baseHappiness;
    @JsonProperty("capture_rate")
    @Expose
    private Integer captureRate;
    @JsonProperty("color")
    @Expose
    private Color color;
    @JsonProperty("egg_groups")
    @Expose
    private List<EggGroup> eggGroups;
    @JsonProperty("evolution_chain")
    @Expose
    private EvolutionChain evolutionChain;
    @JsonProperty("evolves_from_species")
    @Expose
    private Object evolvesFromSpecies;
    @JsonProperty("flavor_text_entries")
    @Expose
    private List<FlavorTextEntry> flavorTextEntries;
    @JsonProperty("form_descriptions")
    @Expose
    private List<Object> formDescriptions;
    @JsonProperty("forms_switchable")
    @Expose
    private Boolean formsSwitchable;
    @JsonProperty("gender_rate")
    @Expose
    private Integer genderRate;
    @JsonProperty("genera")
    @Expose
    private List<Genera> genera;
    @JsonProperty("generation")
    @Expose
    private Generation generation;
    @JsonProperty("growth_rate")
    @Expose
    private GrowthRate growthRate;
    @JsonProperty("habitat")
    @Expose
    private Habitat habitat;
    @JsonProperty("has_gender_differences")
    @Expose
    private Boolean hasGenderDifferences;
    @JsonProperty("hatch_counter")
    @Expose
    private Integer hatchCounter;
    @JsonProperty("id")
    @Expose
    private Integer id;
    @JsonProperty("is_baby")
    @Expose
    private Boolean isBaby;
    @JsonProperty("is_legendary")
    @Expose
    private Boolean isLegendary;
    @JsonProperty("is_mythical")
    @Expose
    private Boolean isMythical;
    @JsonProperty("name")
    @Expose
    private String name;
    @JsonProperty("names")
    @Expose
    private List<Name> names;
    @JsonProperty("order")
    @Expose
    private Integer order;
    @JsonProperty("pal_park_encounters")
    @Expose
    private List<PalParkEncounter> palParkEncounters;
    @JsonProperty("pokedex_numbers")
    @Expose
    private List<PokedexNumber> pokedexNumbers;
    @JsonProperty("shape")
    @Expose
    private Shape shape;
    @JsonProperty("varieties")
    @Expose
    private List<Variety> varieties;
}
