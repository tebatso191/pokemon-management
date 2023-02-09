package za.co.standardbank.card.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PokemonServiceTest {
    PokemonService pokemonService;

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
