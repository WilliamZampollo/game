package br.com.loft.game.entity;

import org.junit.jupiter.api.Test;

import static br.com.loft.game.mock.PersonageMock.getPersonage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonageEntityTest {

    @Test
    public void pernageTest(){
        Personage personage = getPersonage();

        assertEquals(1, personage.getId());
        assertEquals(1, personage.getProfessionId());
        assertEquals("Juninho", personage.getName());
        assertEquals(10, personage.getLifePoints());
        assertEquals(11, personage.getPower());
        assertEquals(12, personage.getSkill());
        assertEquals(13, personage.getIntelligence());
        assertEquals(14, personage.getAttack());
        assertEquals("Attack", personage.getAttackDescription());
        assertEquals(16, personage.getVelocity());
        assertEquals("Velocity", personage.getVelocityDescription());
    }
}
