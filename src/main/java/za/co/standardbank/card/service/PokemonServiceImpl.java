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
import za.co.standardbank.card.dto.response.PokemonDTO;
import za.co.standardbank.card.dto.response.PokemonListDTO;
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
    public PokemonDTO getPokemonDetails(Long id) {
        String url = pokemonBaseUrl.concat(POKEMON_API + id);
        return getPokemonResponse(url);
    }

    private PokemonDTO getPokemonResponse(String url) {
        ResponseEntity<PokemonDTO> responseEntity = restTemplate.getForEntity(url, PokemonDTO.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        if (statusCode.is2xxSuccessful()) {
            PokemonDTO pokemonDTO = responseEntity.getBody();
            log.info(CommonEnum.LOG_RESPONSE_BODY.getValue(), new Gson().toJson(pokemonDTO));
            return responseEntity.getBody();
        } else {
            log.error("Something went wrong. The API Call to : {} Was Unsuccessful.", url);
            throw new IllegalArgumentException("Not Found");
        }
    }

    @Override
    public PokemonListDTO getAListOfPokemon() {
        String url = pokemonBaseUrl.concat(POKEMON_API);
        ResponseEntity<PokemonListDTO> responseEntity = restTemplate.getForEntity(url, PokemonListDTO.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        if (statusCode.is2xxSuccessful()) {
            PokemonListDTO pokemonListDTO = responseEntity.getBody();
            log.info(CommonEnum.LOG_RESPONSE_BODY.getValue(), new Gson().toJson(pokemonListDTO));
            return responseEntity.getBody();
        } else {
            log.error("Something went wrong. The API Call to : {} Was Unsuccessful.", url);
            throw new IllegalArgumentException("Not Found");
        }
    }

    @Override
    public PokemonDTO getPokemonByName(String pokemonName) {
        String url = pokemonBaseUrl.concat(POKEMON_API).concat(pokemonName);
        return getPokemonResponse(url);
    }
}
