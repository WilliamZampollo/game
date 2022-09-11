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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        Profession profession = new Profession(1,"Manager", 10, 11, 12, 13, 14, "Attack", 16, "Velocity");
        ProfessionData professionData = new ProfessionData(1L,"Manager", 10, 11, 12, 13, 14, "Attack", 16, "Velocity");

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
}
