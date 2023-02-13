package za.co.standardbank.card.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.standardbank.card.dto.request.AuthenticationDTO;
import za.co.standardbank.card.dto.response.AuthenticatedDTO;
import za.co.standardbank.card.dto.response.CustomErrorDTO;
import za.co.standardbank.card.service.AuthenticationService;

@RestController
@RequestMapping("/v1/api/authenticate")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
@Tag(name = " Login Management", description = "Microservice For Authentication Management.")
public class AuthenticateController {
    private final AuthenticationService authenticationService;

    @Operation(summary = "Returns Authentication Token")
    @ApiResponse(responseCode = "200", description = "Successful operation",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AuthenticatedDTO.class)))
    @ApiResponse(responseCode = "400", description = "Bad Request",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = CustomErrorDTO.class)))
    @ApiResponse(responseCode = "403", description = "Forbidden",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = CustomErrorDTO.class)))
    @ApiResponse(responseCode = "404", description = "Not Found",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = CustomErrorDTO.class)))
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> authenticateUser(@RequestBody AuthenticationDTO authenticationDTO) throws Exception {
        log.info("Started Authenticating Username : {}", authenticationDTO.getUserName());
        AuthenticatedDTO authenticatedDTO = authenticationService.authenticateUser(authenticationDTO);
        log.info("Completed Authenticating Username : {}", authenticationDTO.getUserName());
        return new ResponseEntity<>(authenticatedDTO, HttpStatus.OK);
    }
}
