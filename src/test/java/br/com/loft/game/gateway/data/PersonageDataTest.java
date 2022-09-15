package br.com.loft.game.gateway.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static br.com.loft.game.mock.PersonageMock.getPersonageData;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonageDataTest {

    @Test
    public void testPersonageData(){
        PersonageData personageData = getPersonageData();

        assertEquals("TestePerson", personageData.getName());
        assertEquals(1L, personageData.getId());
        assertEquals("Manager", personageData.getProfession().getName());
    }
}
