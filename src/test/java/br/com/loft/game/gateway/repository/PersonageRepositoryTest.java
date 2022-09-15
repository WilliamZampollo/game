package br.com.loft.game.gateway.repository;

import br.com.loft.game.gateway.data.PersonageData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static br.com.loft.game.mock.PersonageMock.getPersonageData;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PersonageRepositoryTest {

    @Autowired
    private PersonageRepository repository;

    @Test
    public void insertPersonage(){
        PersonageData personage = getPersonageData();
        PersonageData data = repository.save(personage);
        
        assertEquals("TestePerson", data.getName());
        assertEquals(1, data.getProfession().getId());
    }
}
