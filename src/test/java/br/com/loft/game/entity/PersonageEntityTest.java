package br.com.loft.game.entity;

import org.junit.jupiter.api.Test;

import static br.com.loft.game.mock.PersonageMock.getPersonage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonageEntityTest {

    @Test
    public void pernageTest(){
        Personage personage = getPersonage();

        assertEquals(1, personage.getId());
        assertEquals("Juninho", personage.getName());
        assertTrue(personage.isAlive());
        assertEquals(1, personage.getProfession().getId());
        assertEquals(10, personage.getProfession().getLifePoints());
        assertEquals(11, personage.getProfession().getPower());
        assertEquals(12, personage.getProfession().getSkill());
        assertEquals(13, personage.getProfession().getIntelligence());
        assertEquals(14, personage.getProfession().getAttack());
        assertEquals("Attack", personage.getProfession().getAttackDescription());
        assertEquals(16, personage.getProfession().getVelocity());
        assertEquals("Velocity", personage.getProfession().getVelocityDescription());
    }
}
