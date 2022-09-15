package br.com.loft.game.gateway;

import br.com.loft.game.gateway.converter.PersonageGatewayConverter;
import br.com.loft.game.gateway.converter.ProfessionGatewayConverter;
import br.com.loft.game.gateway.repository.PersonageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static br.com.loft.game.mock.PersonageMock.getPersonageData;
import static br.com.loft.game.mock.ProfessionMock.getProfession;
import static br.com.loft.game.mock.ProfessionMock.getProfessionData;
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
        when(converter.convertToDataObject(any(), any())).thenReturn(getPersonageData());
        when(repository.save(any())).thenReturn(getPersonageData());

        gateway.createPersonage("Teste", getProfession());
     }
}
