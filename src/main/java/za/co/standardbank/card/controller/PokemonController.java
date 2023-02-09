package za.co.standardbank.card.controller;

import com.google.gson.Gson;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.standardbank.card.dto.response.CommonResponse;
import za.co.standardbank.card.dto.response.PokemonDetailResponse;
import za.co.standardbank.card.service.PokemonService;
import za.co.standardbank.card.util.PokemonUtil;

@RestController
@RequestMapping("/v1/api/pokemon")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class PokemonController {
    private final PokemonService pokemonService;

    @GetMapping(path = {"details/{pokemon-id}"})
    @Operation(summary = "Returns Pokemon Details")
    @ApiResponse(responseCode = "200", description = "Successful operation",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = PokemonDetailResponse.class)))
    @ApiResponse(responseCode = "400", description = "Bad Request",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = PokemonDetailResponse.class)))

    @ResponseBody
    public ResponseEntity<Object> getPokemonDetails(@PathVariable("pokemon-id") String id) {
        try {
            log.info("Started Path Variable ID : {}", id);
            PokemonDetailResponse pokemonDetailResponse = pokemonService.getPokemonDetails(id);
            CommonResponse commonResponse = PokemonUtil.buildSuccessResponse(pokemonDetailResponse);
            log.info("Completed Path Variable ID : {}", id);
            return new ResponseEntity<>(commonResponse, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error Occurred. Path Variable Name : {}. Error Message : {}", id, e.getMessage());
            CommonResponse commonResponse = PokemonUtil.buildFailedResponse(e);
            return new ResponseEntity<>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
