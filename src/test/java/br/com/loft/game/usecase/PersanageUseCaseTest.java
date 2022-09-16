package br.com.loft.game.usecase;

import br.com.loft.game.entity.Personage;
import br.com.loft.game.exception.CreatePersonageWithoutProfessionException;
import br.com.loft.game.exception.PeronageNotFoundException;
import br.com.loft.game.exception.ProfessionNotFoundException;
import br.com.loft.game.gateway.PersonageGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static br.com.loft.game.mock.PersonageMock.getPersonage;
import static br.com.loft.game.mock.ProfessionMock.getProfession;
import static org.junit.jupiter.api.Assertions.*;
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
        doNothing().when(personageGateway).createPersonage("TesteUSer", true, getProfession());
        personageUseCase.createPersonage("TesteUSer", 1);
    }

    @Test
    public void createPersonageWithWrongProfession(){
        when(professionUseCase.findById(any())).thenThrow(new ProfessionNotFoundException());
        assertThrows(CreatePersonageWithoutProfessionException.class, () -> personageUseCase.createPersonage("TesteUSer", 35));

    }

    @Test
    public void getPersonages(){
        when(personageGateway.findAllPersonages()).thenReturn(List.of(getPersonage()));
        List<Personage> personages = personageUseCase.getPersonages();
        assertEquals("Juninho", personages.get(0).getName());
        assertTrue(personages.get(0).isAlive());
    }

    @Test
    public void getPersonagesFail(){
        when(personageGateway.findAllPersonages()).thenThrow(new PeronageNotFoundException());
        assertThrows(PeronageNotFoundException.class, () -> personageUseCase.getPersonages());
    }
}
