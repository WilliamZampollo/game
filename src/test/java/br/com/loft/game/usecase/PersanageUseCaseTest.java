package br.com.loft.game.usecase;

import br.com.loft.game.exception.CreatePersonageWithoutProfessionException;
import br.com.loft.game.exception.ProfessionNotFoundException;
import br.com.loft.game.gateway.PersonageGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static br.com.loft.game.mock.ProfessionMock.getProfession;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PersanageUseCaseTest {

    @Autowired
    private PersonageUseCase personageUseCase;

    @MockBean
    private PersonageGateway personageGateway;

    @MockBean
    private ProfessionUseCase professionUseCase;

    @Test
    public void createPersonage(){
        when(professionUseCase.findById(any())).thenReturn(getProfession());
        doNothing().when(personageGateway).createPersonage(any(), any());
        personageUseCase.createPersonage("TesteUSer", 1);
    }

    @Test
    public void createPersonageWithWrongProfession(){
        when(professionUseCase.findById(any())).thenThrow(new ProfessionNotFoundException());
        assertThrows(CreatePersonageWithoutProfessionException.class, () -> personageUseCase.createPersonage("TesteUSer", 1));

    }
}
