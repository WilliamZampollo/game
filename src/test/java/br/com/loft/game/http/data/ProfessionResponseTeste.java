package br.com.loft.game.http.data;

import br.com.loft.game.http.data.response.ProfessionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static br.com.loft.game.mock.ProfessionMock.getProfessionResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProfessionResponseTeste {

    @Test
    public void testPersonagePostRequest(){
        ProfessionResponse professionResponse = getProfessionResponse();
        assertEquals("Manager", professionResponse.getName());
        assertEquals(10, professionResponse.getLifePoints());
    }
}
