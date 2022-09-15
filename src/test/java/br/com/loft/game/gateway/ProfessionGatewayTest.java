package br.com.loft.game.gateway;

import br.com.loft.game.entity.Profession;
import br.com.loft.game.exception.ProfessionNotFoundException;
import br.com.loft.game.gateway.converter.ProfessionGatewayConverter;
import br.com.loft.game.gateway.data.ProfessionData;
import br.com.loft.game.gateway.repository.ProfessionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static br.com.loft.game.mock.ProfessionMock.getProfession;
import static br.com.loft.game.mock.ProfessionMock.getProfessionData;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProfessionGatewayTest {

    @Autowired
    private ProfessionGateway gateway;
    @MockBean
    private ProfessionRepository professionRepository;
    @MockBean
    private ProfessionGatewayConverter converter;

    @Test
    public void getProfessions(){
        Profession profession = getProfession();
        ProfessionData professionData = getProfessionData();

        when(professionRepository.findAll()).thenReturn(List.of(professionData));
        when(converter.converterToProfessionList(any())).thenReturn(List.of(profession));

        List<Profession> professionList = gateway.getProfessions();

        assertEquals(profession.getAttackDescription(), professionList.get(0).getAttackDescription());
        assertEquals(profession.getVelocityDescription(), professionList.get(0).getVelocityDescription());
    }

    @Test
    public void getNullProfessions(){
        when(professionRepository.findAll()).thenReturn(new ArrayList<>());
        assertThrows(ProfessionNotFoundException.class, () -> gateway.getProfessions(), "Nenhuma profissão encontrada.");
    }

    @Test
    public void existsById() {
        when(professionRepository.existsById(any())).thenReturn(true);
        boolean exists = gateway.existsById(1);
        assertTrue(exists);
    }

    @Test
    public void notExistsById() {
        when(professionRepository.existsById(any())).thenReturn(false);
        boolean exists = gateway.existsById(1);
        assertFalse(exists);
    }

    @Test
    public void findById() {
        when(professionRepository.findById(any())).thenReturn(Optional.of(getProfessionData()));
        when(converter.converterToProfession(any())).thenReturn(getProfession());

        Profession profession = gateway.findById(1);

        assertEquals("Manager", profession.getName());
        assertEquals(14, profession.getAttack());
    }

    @Test
    public void findByIdWithEmptyProfession() {
        when(professionRepository.findById(any())).thenReturn(Optional.empty());
        assertThrows(ProfessionNotFoundException.class, () -> gateway.findById(1), "Nenhuma profissão encontrada.");
    }

}
