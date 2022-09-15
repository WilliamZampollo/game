package br.com.loft.game.gateway.converter;

import br.com.loft.game.gateway.data.PersonageData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static br.com.loft.game.mock.PersonageMock.getPersonageData;
import static br.com.loft.game.mock.ProfessionMock.getProfessionData;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonageGatewayConverterTest {

    @Autowired
    private PersonageGatewayConverter personageGatewayConverter;

    @Test
    public void convertToDataObject(){
        PersonageData personageData = personageGatewayConverter.convertToDataObject("Rubens", getProfessionData());

        assertEquals("Rubens", personageData.getName());
        assertEquals(1L, personageData.getProfession().getId());
    }
}
