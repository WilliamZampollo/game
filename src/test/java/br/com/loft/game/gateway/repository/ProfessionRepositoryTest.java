package br.com.loft.game.gateway.repository;

import br.com.loft.game.gateway.data.ProfessionData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static java.util.Optional.empty;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ProfessionRepositoryTest {

    @Autowired
    private ProfessionRepository repository;

    @Test
    public void insertProfession(){
        ProfessionData profession = new ProfessionData(1L,"Manager", 10, 11, 12, 13, 14, "Attack", 16, "Velocity");
        repository.save(profession);
        Integer countProfessions = repository.findAll().size();
        assertEquals(1, countProfessions);
    }

    @Test
    public void checkProfessionSavedWithIdPassingOtherIdShouldReturnNull() {
        ProfessionData profession = new ProfessionData(1L,"Manager", 10, 11, 12, 13, 14, "Attack", 16, "Velocity");
        repository.save(profession);
        Integer countProfessions = repository.findAll().size();
        assertEquals(1, countProfessions);
        Optional<ProfessionData> profession1 = repository.findById(5L);

        assertEquals(empty(), profession1);
    }

}
