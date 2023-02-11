package za.co.standardbank.card.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import za.co.standardbank.card.dto.response.PokemonListDTO;
import za.co.standardbank.card.dto.response.PokemonDTO;
import za.co.standardbank.card.service.PokemonService;

@RestController
@RequestMapping("/v1/api/pokemon")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
@Tag(name = " Pokemon Management", description = "Microservice For Pokemon Management.")
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, bearerFormat = "JWT", scheme = "bearer")
@SecurityRequirement(name = "bearerAuth")
public class PokemonController {
    private final PokemonService pokemonService;

    @Operation(summary = "Returns Pokemon Details By Providing Pokemon Id")
    @ApiResponse(responseCode = "200", description = "Successful operation",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = PokemonDTO.class)))
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
        PokemonDTO pokemonDTO = pokemonService.getPokemonDetails(id);
        log.info("Completed Path Variable ID : {}", id);
        return new ResponseEntity<>(pokemonDTO, HttpStatus.OK);
    }

    @Operation(summary = "Returns A List Of Pokemons")
    @ApiResponse(responseCode = "200", description = "Successful operation",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = PokemonListDTO.class)))
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
        PokemonListDTO aListOfPokemons = pokemonService.getAListOfPokemon();
        log.info("Completed Getting All Pokemon");
        return new ResponseEntity<>(aListOfPokemons, HttpStatus.OK);
    }

    @Operation(summary = "Returns Pokemon Details")
    @ApiResponse(responseCode = "200", description = "Successful operation",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = PokemonDTO.class)))
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
        PokemonDTO pokemonDTO = pokemonService.getPokemonByName(pokemonName);
        log.info("Completed Getting Pokemon By Name. Request Param : {}", pokemonName);
        return new ResponseEntity<>(pokemonDTO, HttpStatus.OK);
    }
}
