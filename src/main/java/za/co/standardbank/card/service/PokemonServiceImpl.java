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
import za.co.standardbank.card.dto.response.PokemonDetailResponse;

import java.util.Objects;


@Service
@RequiredArgsConstructor
@Slf4j
public class PokemonServiceImpl implements PokemonService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${endpoint.pokemon}")
    private String pokemonAPI;

    @Override
    public PokemonDetailResponse getPokemonDetails(String name) {
        ResponseEntity<String> response = restTemplate.getForEntity(pokemonAPI.concat("pokemon/").concat(name).concat("/"), String.class);
        HttpStatus statusCode = response.getStatusCode();
        if (statusCode.is2xxSuccessful()) {
            String s1 = new Gson().toJson(response.getBody());
            log.info(" {}", s1);
            String s = Objects.requireNonNull(response.getBody());
            log.info("Response : {}", s);
            return PokemonDetailResponse.builder().build();
        } else {
            throw new IllegalArgumentException("Not Found");
        }
    }
}
