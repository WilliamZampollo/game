package br.com.loft.game.gateway.converter.impl;

import br.com.loft.game.entity.Personage;
import br.com.loft.game.gateway.converter.PersonageGatewayConverter;
import br.com.loft.game.gateway.converter.ProfessionGatewayConverter;
import br.com.loft.game.gateway.data.PersonageData;
import br.com.loft.game.gateway.data.ProfessionData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PersonageGatewayConverterImpl implements PersonageGatewayConverter {

    private final ProfessionGatewayConverter professionGatewayConverter;

    @Override
    public PersonageData convertToDataObject(String name, boolean alive, ProfessionData profession) {
        return PersonageData.builder()
                .name(name)
                .alive(alive)
                .profession(profession)
                .build();
    }

    @Override
    public List<Personage> convertToEntityList(List<PersonageData> personages) {
        List<Personage> convertedList = new ArrayList<>();
        personages.forEach(p -> convertedList.add(converterToPersonage(p)));
        return convertedList;
    }

    @Override
    public Personage converterToPersonage(PersonageData p) {
        return Personage.builder()
                .id((int) p.getId())
                .name(p.getName())
                .alive(p.isAlive())
                .profession(professionGatewayConverter.converterToProfession(p.getProfession()))
                .build();
    }
}
