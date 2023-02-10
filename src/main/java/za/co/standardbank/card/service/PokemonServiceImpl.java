package za.co.standardbank.card.service;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import za.co.standardbank.card.dto.response.PokemonListResponse;
import za.co.standardbank.card.dto.response.PokemonResponse;
import za.co.standardbank.card.enums.CommonEnum;


@Service
@RequiredArgsConstructor
@Slf4j
public class PokemonServiceImpl implements PokemonService {
    public static final String POKEMON_API = "pokemon-species/";
    @Autowired
    private RestTemplate restTemplate;
    @Value("${endpoint.pokemon}")
    private String pokemonBaseUrl;
    private String pokemonAPI;

    @Override
    public PokemonResponse getPokemonDetails(Long id) {
        String url = pokemonBaseUrl.concat(POKEMON_API + id);
        return getPokemonResponse(url);
    }

    private PokemonResponse getPokemonResponse(String url) {
        ResponseEntity<PokemonResponse> responseEntity = restTemplate.getForEntity(url, PokemonResponse.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        if (statusCode.is2xxSuccessful()) {
            PokemonResponse pokemonResponse = responseEntity.getBody();
            log.info(CommonEnum.RESPONSE_BODY_LOG.getValue(), new Gson().toJson(pokemonResponse));
            return responseEntity.getBody();
        } else {
            log.error("Something went wrong. The API Call to : {} Was Unsuccessful.", url);
            throw new IllegalArgumentException("Not Found");
        }
    }

    @Override
    public PokemonListResponse getAListOfPokemon() {
        String url = pokemonBaseUrl.concat(POKEMON_API);
        ResponseEntity<PokemonListResponse> responseEntity = restTemplate.getForEntity(url, PokemonListResponse.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        if (statusCode.is2xxSuccessful()) {
            PokemonListResponse pokemonListResponse = responseEntity.getBody();
            log.info(CommonEnum.RESPONSE_BODY_LOG.getValue(), new Gson().toJson(pokemonListResponse));
            return responseEntity.getBody();
        } else {
            log.error("Something went wrong. The API Call to : {} Was Unsuccessful.", url);
            throw new IllegalArgumentException("Not Found");
        }
    }

    @Override
    public PokemonResponse getPokemonByName(String pokemonName) {
        String url = pokemonBaseUrl.concat(POKEMON_API).concat(pokemonName);
        return getPokemonResponse(url);
    }
}
