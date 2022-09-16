package br.com.loft.game.gateway.converter;

import br.com.loft.game.entity.Personage;
import br.com.loft.game.gateway.data.PersonageData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static br.com.loft.game.mock.PersonageMock.getPersonageData;
import static br.com.loft.game.mock.ProfessionMock.getProfessionData;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonageGatewayConverterTest {

    @Autowired
    private PersonageGatewayConverter personageGatewayConverter;

    @Test
    public void convertToDataObject(){
        PersonageData personageData = personageGatewayConverter.convertToDataObject("Rubens", true, getProfessionData());

        assertEquals("Rubens", personageData.getName());
        assertEquals(1L, personageData.getProfession().getId());
    }

    @Test
    public void convertToEntityList(){
        List<Personage> convertedList = personageGatewayConverter.convertToEntityList(List.of(getPersonageData()));

        assertEquals("TestePerson", convertedList.get(0).getName());
        assertEquals(1, convertedList.get(0).getProfession().getId());
    }
}
