package br.com.loft.game.gateway;

import br.com.loft.game.entity.Personage;
import br.com.loft.game.exception.PeronageNotFoundException;
import br.com.loft.game.exception.ProfessionNotFoundException;
import br.com.loft.game.gateway.converter.PersonageGatewayConverter;
import br.com.loft.game.gateway.converter.ProfessionGatewayConverter;
import br.com.loft.game.gateway.repository.PersonageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static br.com.loft.game.mock.PersonageMock.getPersonage;
import static br.com.loft.game.mock.PersonageMock.getPersonageData;
import static br.com.loft.game.mock.ProfessionMock.getProfession;
import static br.com.loft.game.mock.ProfessionMock.getProfessionData;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PersonageGatewayTest {

    @Autowired
    private PersonageGateway gateway;

    @MockBean
    private PersonageRepository repository;

    @MockBean
    private PersonageGatewayConverter converter;

    @MockBean
    private ProfessionGatewayConverter professionConverter;

    @Test
    public void createPersonage(){
        when(professionConverter.convertToDataObject(getProfession())).thenReturn(getProfessionData());
        when(converter.convertToDataObject("name", true, getProfessionData())).thenReturn(getPersonageData());
        when(repository.save(any())).thenReturn(getPersonageData());

        gateway.createPersonage("Teste", true, getProfession());
    }

    @Test
    public void findAllPersonages(){
        when(repository.findAll()).thenReturn(List.of(getPersonageData()));
        when(converter.convertToEntityList(any())).thenReturn(List.of(getPersonage()));

        List<Personage> allPersonages = gateway.findAllPersonages();

        assertEquals("Juninho", allPersonages.get(0).getName());
        assertEquals(1, allPersonages.get(0).getId());
    }

    @Test
    public void findAllPersonagesError(){
        when(repository.findAll()).thenReturn(new ArrayList<>());
        assertThrows(PeronageNotFoundException.class, () -> gateway.findAllPersonages(), "Nenhum personagem encontrado.");
    }
}
