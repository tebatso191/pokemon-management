package za.co.standardbank.card.service;

import za.co.standardbank.card.dto.response.PokemonListResponse;
import za.co.standardbank.card.dto.response.PokemonResponse;

public interface PokemonService {
    PokemonResponse getPokemonDetails(Long id);

    PokemonListResponse getAListOfPokemon();

    PokemonResponse getPokemonByName(String searchPokemonRequest);
}
