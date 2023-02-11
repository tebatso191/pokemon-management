package za.co.standardbank.card.service;

import za.co.standardbank.card.dto.response.PokemonListDTO;
import za.co.standardbank.card.dto.response.PokemonDTO;

public interface PokemonService {
    PokemonDTO getPokemonDetails(Long id);

    PokemonListDTO getAListOfPokemon();

    PokemonDTO getPokemonByName(String searchPokemonRequest);
}
