package za.co.standardbank.card.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import za.co.standardbank.card.dto.response.PokemonListResponse;
import za.co.standardbank.card.dto.response.PokemonResponse;
import za.co.standardbank.card.service.PokemonService;

@RestController
@RequestMapping("/v1/api/pokemon")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
@OpenAPIDefinition(info = @Info(title = "Pokemon Management", description = "This is A Microservice For Pokemon Management.", version = "2.0"))
public class PokemonController {
    private final PokemonService pokemonService;

    @Operation(summary = "Returns Pokemon Details By Providing Pokemon Id")
    @ApiResponse(responseCode = "200", description = "Successful operation",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = PokemonResponse.class)))
    @ApiResponse(responseCode = "400", description = "Bad Request",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = HttpClientErrorException.BadRequest.class)))
    @ApiResponse(responseCode = "403", description = "Forbidden",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = HttpClientErrorException.Forbidden.class)))
    @ApiResponse(responseCode = "404", description = "Not Found",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = HttpClientErrorException.NotFound.class)))
    @GetMapping(path = {"details/{pokemon-id}"})
    @ResponseBody
    public ResponseEntity<Object> getPokemonDetails(@PathVariable(name = "pokemon-id") Long id) {
        log.info("Started Path Variable ID : {}", id);
        PokemonResponse pokemonResponse = pokemonService.getPokemonDetails(id);
        log.info("Completed Path Variable ID : {}", id);
        return new ResponseEntity<>(pokemonResponse, HttpStatus.OK);
    }

    @Operation(summary = "Returns A List Of Pokemons")
    @ApiResponse(responseCode = "200", description = "Successful operation",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = PokemonListResponse.class)))
    @ApiResponse(responseCode = "400", description = "Bad Request",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = HttpClientErrorException.BadRequest.class)))
    @ApiResponse(responseCode = "403", description = "Forbidden",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = HttpClientErrorException.Forbidden.class)))
    @ApiResponse(responseCode = "404", description = "Not Found",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = HttpClientErrorException.NotFound.class)))
    @GetMapping(path = {"list"})
    @ResponseBody
    public ResponseEntity<Object> getAListOfPokemon() {
        log.info("Started Getting All Pokemon");
        PokemonListResponse aListOfPokemons = pokemonService.getAListOfPokemon();
        log.info("Completed Getting All Pokemon");
        return new ResponseEntity<>(aListOfPokemons, HttpStatus.OK);
    }

    @Operation(summary = "Returns Pokemon Details")
    @ApiResponse(responseCode = "200", description = "Successful operation",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = PokemonResponse.class)))
    @ApiResponse(responseCode = "400", description = "Bad Request",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = HttpClientErrorException.BadRequest.class)))
    @ApiResponse(responseCode = "403", description = "Forbidden",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = HttpClientErrorException.Forbidden.class)))
    @ApiResponse(responseCode = "404", description = "Not Found",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = HttpClientErrorException.NotFound.class)))
    @GetMapping(path = {"search"})
    @ResponseBody
    public ResponseEntity<Object> getPokemonByName(@RequestParam(value = "pokemon-name", defaultValue = "bulbasaur") String pokemonName) {
        log.info("Started Getting Pokemon By Name. Request Param : {}", pokemonName);
        PokemonResponse pokemonResponse = pokemonService.getPokemonByName(pokemonName);
        log.info("Completed Getting Pokemon By Name. Request Param : {}", pokemonName);
        return new ResponseEntity<>(pokemonResponse, HttpStatus.OK);
    }
}
