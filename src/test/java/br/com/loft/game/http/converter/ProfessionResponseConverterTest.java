package br.com.loft.game.http.converter;

import br.com.loft.game.entity.Profession;
import br.com.loft.game.http.data.response.ProfessionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProfessionResponseConverterTest {
    @Autowired
    private ProfessionConverter converter;

    @Test
    public void converter(){
        Profession profession = new Profession(1,"Manager", 10, 11, 12, 13, 14, "Attack", 16, "Velocity");
        List<ProfessionResponse> professionResponse = converter.converterToProfessionList(List.of(profession));

        assertEquals(profession.getId(), professionResponse.get(0).getId());
    }
}
