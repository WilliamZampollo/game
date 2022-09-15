package br.com.loft.game.http.data;

import br.com.loft.game.http.data.request.PersonageRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static br.com.loft.game.mock.PersonageMock.getPersonageRequest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonageRequestTest {

    @Test
    public void testPersonagePostRequest(){
        PersonageRequest personageRequest = getPersonageRequest();
        assertEquals("TestePerson", personageRequest.getName());
        assertEquals(1, personageRequest.getProfessionId());
    }
}
