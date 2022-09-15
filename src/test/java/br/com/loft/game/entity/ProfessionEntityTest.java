package br.com.loft.game.entity;

import org.junit.jupiter.api.Test;

import static br.com.loft.game.mock.ProfessionMock.getProfession;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfessionEntityTest {

    @Test
    public void professionTest(){
        Profession profession = getProfession();
        assertEquals(1, profession.getId());
        assertEquals("Manager", profession.getName());
        assertEquals(10, profession.getLifePoints());
        assertEquals(11, profession.getPower());
        assertEquals(12, profession.getSkill());
        assertEquals(13, profession.getIntelligence());
        assertEquals(14, profession.getAttack());
        assertEquals("Attack", profession.getAttackDescription());
        assertEquals(16, profession.getVelocity());
        assertEquals("Velocity", profession.getVelocityDescription());
    }
}
