package br.com.loft.game.http.converter;

import br.com.loft.game.http.data.response.SimplePersonageResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static br.com.loft.game.mock.PersonageMock.getPersonage;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonageConverterTest {

    @Autowired
    private PersonageConverter personageConverter;

    @Test
    public void convertToListOfSimplePersonageResponse(){
        List<SimplePersonageResponse> simplePersonageResponseList = personageConverter.convertToListOfSimplePersonageResponse(List.of(getPersonage()));

        assertEquals("Juninho", simplePersonageResponseList.get(0).getName());
        assertEquals(1, simplePersonageResponseList.get(0).getId());
    }
}
