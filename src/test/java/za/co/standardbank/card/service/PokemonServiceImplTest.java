package za.co.standardbank.card.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;
import za.co.standardbank.card.dto.response.PokemonDTO;
import za.co.standardbank.card.dto.response.PokemonListDTO;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PokemonServiceImplTest {
    @Mock
    private RestTemplate restTemplate;
    @InjectMocks
    private PokemonServiceImpl pokemonService;

    @BeforeEach
    public void setUp() {
        ReflectionTestUtils.setField(pokemonService, "pokemonBaseUrl", "https://pokeapi.co/api/v2/");
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getPokemonDetails_ShouldReturnPokemonDTO() {
        Long id = 1L;
        PokemonDTO pokemonDTO = new PokemonDTO();
        when(restTemplate.getForEntity(anyString(), any())).thenReturn(ResponseEntity.ok(pokemonDTO));

        PokemonDTO result = pokemonService.getPokemonDetails(id);

        assertNotNull(result);
        assertEquals(pokemonDTO, result);
    }

    @Test
    void testGetPokemonDetails_withInvalidId_throwsException() {
        when(restTemplate.getForEntity(anyString(), any()))
                .thenReturn(new ResponseEntity(HttpStatus.NOT_FOUND));
        assertThrows(IllegalArgumentException.class, () -> pokemonService.getPokemonDetails(1L));
    }

    @Test
    void getAListOfPokemon_ShouldReturnPokemonListDTO() {
        PokemonListDTO pokemonListDTO = new PokemonListDTO();
        when(restTemplate.getForEntity(anyString(), any())).thenReturn(ResponseEntity.ok(pokemonListDTO));

        PokemonListDTO result = pokemonService.getAListOfPokemon();

        assertNotNull(result);
        assertEquals(pokemonListDTO, result);
    }

    @Test
    void getAListOfPokemon_withInvalidId_throwsException() {
        when(restTemplate.getForEntity(anyString(), any()))
                .thenReturn(new ResponseEntity(HttpStatus.NOT_FOUND));
        assertThrows(IllegalArgumentException.class, () -> pokemonService.getAListOfPokemon());
    }

    @Test
    void getPokemonByName_ShouldReturnPokemonDTO() {
        String pokemonName = "pikachu";
        PokemonDTO pokemonDTO = new PokemonDTO();
        when(restTemplate.getForEntity(anyString(), any())).thenReturn(ResponseEntity.ok(pokemonDTO));

        PokemonDTO result = pokemonService.getPokemonByName(pokemonName);

        assertNotNull(result);
        assertEquals(pokemonDTO, result);
    }
}
