package br.com.loft.game.usecase;

import br.com.loft.game.entity.Profession;
import br.com.loft.game.gateway.ProfessionGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static br.com.loft.game.mock.ProfessionMock.getProfession;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProfessionUseCaseTest {

    @Autowired
    private ProfessionUseCase professionUseCase;

    @MockBean
    private ProfessionGateway professionGateway;

    @Test
    public void getProfessions(){
        Profession profession = getProfession();
                when(professionGateway.getProfessions()).thenReturn(List.of(profession));

        List<Profession> professions = professionUseCase.getProfessions();

        assertEquals(profession.getSkill(), professions.get(0).getSkill());
        assertEquals(profession.getIntelligence(), professions.get(0).getIntelligence());
        assertEquals(profession.getAttack(), professions.get(0).getAttack());
        assertEquals(profession.getVelocity(), professions.get(0).getVelocity());
    }

    @Test
    public void getProfessionsByID(){
        Profession profession = getProfession();
        when(professionGateway.findById(any())).thenReturn(profession);

        Profession data = professionUseCase.findById(1);

        assertEquals(profession.getSkill(), data.getSkill());
        assertEquals(profession.getIntelligence(), data.getIntelligence());
        assertEquals(profession.getAttack(), data.getAttack());
        assertEquals(profession.getVelocity(), data.getVelocity());
    }
}
