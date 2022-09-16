package br.com.loft.game.gateway.repository;

import br.com.loft.game.gateway.data.PersonageData;
import br.com.loft.game.gateway.data.ProfessionData;
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

    @Autowired
    private ProfessionRepository professionRepository;

    @Test
    public void insertPersonage(){
        professionRepository.save(new ProfessionData(1L,"Warrior", 20, 10, 5, 5, 9, "80% da Força + 20% da Destreza", 4, "60% da Destreza + 20% da Inteligência",null));
        PersonageData data = repository.save(getPersonageData());
        
        assertEquals("TestePerson", data.getName());
        assertEquals(1, data.getProfession().getId());
    }
}
