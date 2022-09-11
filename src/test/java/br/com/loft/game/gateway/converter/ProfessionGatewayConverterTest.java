package br.com.loft.game.gateway.converter;

import br.com.loft.game.entity.Profession;
import br.com.loft.game.gateway.data.ProfessionData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProfessionGatewayConverterTest {
    @Autowired
    private ProfessionGatewayConverter converter;

    @Test
    public void converter(){
        ProfessionData profession = new ProfessionData(1L,"Manager", 10, 11, 12, 13, 14, "Attack", 16, "Velocity");
        List<Profession> professionList = converter.converterToProfessionList(List.of(profession));

        assertEquals(profession.getLifePoints(), professionList.get(0).getLifePoints());
        assertEquals(profession.getName(), professionList.get(0).getName());
    }
}
