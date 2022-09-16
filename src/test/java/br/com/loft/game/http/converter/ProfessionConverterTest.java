package br.com.loft.game.http.converter;

import br.com.loft.game.http.data.response.ProfessionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static br.com.loft.game.mock.ProfessionMock.getProfession;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProfessionConverterTest {
    @Autowired
    private ProfessionConverter converter;

    @Test
    public void converter(){
        List<ProfessionResponse> professionResponse = converter.converterToProfessionList(List.of(getProfession()));

        assertEquals(1, professionResponse.get(0).getId());
    }
}
