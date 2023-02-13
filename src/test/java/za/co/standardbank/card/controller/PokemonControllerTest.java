package za.co.standardbank.card.controller;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.ResponseBodyExtractionOptions;
import com.jayway.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import za.co.standardbank.card.dto.request.AuthenticationDTO;
import za.co.standardbank.card.dto.response.AuthenticatedDTO;

import java.util.Objects;

import static com.jayway.restassured.RestAssured.given;

class PokemonControllerTest {
    String token = "";

    @BeforeEach
    private void setup() throws Exception {
        String port = System.getProperty("server.port");
        if (Objects.isNull(port)) {
            RestAssured.port = 5000;
        } else {
            RestAssured.port = Integer.parseInt(port);
        }

        String basePath = System.getProperty("server.base");
        if (basePath == null) {
            basePath = "";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;
        token = getToken();
    }

    private String getToken() throws Exception {
        AuthenticationDTO authenticationDTO = AuthenticationDTO.builder().userName("admin").password("admin").build();

        ValidatableResponse validatableResponse = given()
                .contentType(ContentType.JSON)
                .body(new Gson().toJson(authenticationDTO))
                .log()
                .all()
                .expect()
                .log()
                .all()
                .when()
                .post("v1/api/authenticate")
                .then()
                .statusCode(HttpStatus.OK.value());

        ResponseBodyExtractionOptions body = validatableResponse.extract().body();
        AuthenticatedDTO authenticatedDTO = new Gson().fromJson(body.asString(), AuthenticatedDTO.class);
        if (Objects.nonNull(authenticatedDTO))
            return authenticatedDTO.getToken();
        else throw new Exception("Could Not Authenticate the User");
    }

    @Test
    @Order(1)
    @Disabled("Disabled Because it is API Test and the Application must be running in order for the test to pass.")
    void shouldTestGetPokemonDetails_thenReturnResults() {
        given()
                .header("Authorization", "Bearer ".concat(token))
                .log()
                .all()
                .expect()
                .log()
                .all()
                .when()
                .get("v1/api/pokemon/details/2")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    @Order(2)
    @Disabled("Disabled Because it is API Test and the Application must be running in order for the test to pass.")
    void shouldTestGetAListOfPokemon_thenReturnResults() {

        given()
                .log()
                .all()
                .expect()
                .log()
                .all()
                .when()
                .get("v1/api/pokemon")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    @Order(3)
    @Disabled("Disabled Because it is API Test and the Application must be running in order for the test to pass.")
    void shouldTestGetPokemonByName_thenReturnResults() {

        given()
                .param("pokemon-name", "bulbasaur")
                .log()
                .all()
                .expect()
                .log()
                .all()
                .when()
                .get("v1/api/pokemon")
                .then()
                .statusCode(HttpStatus.OK.value());
    }
}