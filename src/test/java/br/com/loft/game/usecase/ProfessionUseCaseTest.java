package br.com.loft.game.usecase;

import br.com.loft.game.entity.Profession;
import br.com.loft.game.gateway.ProfessionGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProfessionUseCaseTest {

    @Autowired
    private ProfessionUseCase professionUseCase;

    @MockBean
    private ProfessionGateway professionGateway;

    @Test
    public void testUseCase(){
        Profession profession = new Profession(1,"Manager", 10, 11, 12, 13, 14, "Attack", 16, "Velocity");
        when(professionGateway.getProfessions()).thenReturn(List.of(profession));

        List<Profession> professions = professionUseCase.getProfessions();

        assertEquals(profession.getSkill(), professions.get(0).getSkill());
        assertEquals(profession.getIntelligence(), professions.get(0).getIntelligence());
        assertEquals(profession.getAttack(), professions.get(0).getAttack());
        assertEquals(profession.getVelocity(), professions.get(0).getVelocity());
    }
}
