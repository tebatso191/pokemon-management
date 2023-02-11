package za.co.standardbank.card.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import za.co.standardbank.card.dto.response.PokemonDTO;

@ExtendWith(MockitoExtension.class)
class PokemonServiceTest {
    @Autowired
    private PokemonService pokemonService;

    @BeforeEach
    public void init() {
        pokemonService = new PokemonServiceImpl();
    }

    @Test
    void TestDInDB() {
//        //given
//        mockKanbanInDatabase(2);
//
//        //when
//        List<DigitalIdentity> kanbans = digitalIdentityService.getAllKanbanBoards();
//
//        //then
//        Assertions.assertEquals(2, kanbans.size());
    }

    @Test
    @Order(1)
    void shouldTestGetPokemonDetails_thenReturnResults() {
        //given
        Long pokemonId = 1L;
        pokemonService = new PokemonServiceImpl();

        //when
        PokemonDTO pokemonDetails = pokemonService.getPokemonDetails(pokemonId);

        //then
        //Assertions.assertEquals(2, pokemonDetails.size());
    }

//    @Test
//    void KanbanWithIdExistInDB_thenGetKanban() {
//        //given
//        when(digitalIdentityRepository.findById(2L))
//                .thenReturn(Optional.of(getKanban(2L)));
//        //when
//        DigitalIdentity kanban = digitalIdentityService.getKanbanById(2L).get();
//        //then
//        Assertions.assertEquals(2L, (long) kanban.getId());
//    }
}
