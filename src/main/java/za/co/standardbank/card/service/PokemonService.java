package za.co.standardbank.card.service;

import za.co.standardbank.card.dto.response.PokemonDetailResponse;

public interface PokemonService {
    PokemonDetailResponse getPokemonDetails(String name);
}
