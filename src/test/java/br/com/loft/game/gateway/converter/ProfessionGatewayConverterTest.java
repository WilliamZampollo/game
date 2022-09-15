package br.com.loft.game.gateway.converter;

import br.com.loft.game.entity.Profession;
import br.com.loft.game.gateway.data.ProfessionData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static br.com.loft.game.mock.ProfessionMock.getProfession;
import static br.com.loft.game.mock.ProfessionMock.getProfessionData;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProfessionGatewayConverterTest {
    @Autowired
    private ProfessionGatewayConverter converter;

    @Test
    public void converterToList(){
        ProfessionData profession = getProfessionData();
        List<Profession> professionList = converter.converterToProfessionList(List.of(profession));

        assertEquals(profession.getLifePoints(), professionList.get(0).getLifePoints());
        assertEquals(profession.getName(), professionList.get(0).getName());
    }

    @Test
    public void converter(){
        Profession profession = getProfession();
        ProfessionData professionData= converter.convertToDataObject(profession);

        assertEquals(profession.getLifePoints(), professionData.getLifePoints());
        assertEquals(profession.getName(), professionData.getName());
    }
}
