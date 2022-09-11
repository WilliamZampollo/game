package br.com.loft.game.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfessionEntityTest {

    @Test
    public void professionTest(){
        Profession profession = new Profession(1,"Manager", 10, 11, 12, 13, 14, "Attack", 16, "Velocity");
        assertEquals("Manager", profession.getName());
        assertEquals(10, profession.getLifePoints());
    }
}
