package br.com.loft.game.gateway.impl;

import br.com.loft.game.entity.Profession;
import br.com.loft.game.gateway.PersonageGateway;
import br.com.loft.game.gateway.converter.PersonageGatewayConverter;
import br.com.loft.game.gateway.converter.ProfessionGatewayConverter;
import br.com.loft.game.gateway.data.PersonageData;
import br.com.loft.game.gateway.data.ProfessionData;
import br.com.loft.game.gateway.repository.PersonageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonageGatewayImpl implements PersonageGateway {

    private final PersonageRepository repository;
    private final PersonageGatewayConverter converter;
    private final ProfessionGatewayConverter professionConverter;

    @Override
    public void createPersonage(String name, Profession profession) {
        ProfessionData professionData = professionConverter.convertToDataObject(profession);
        PersonageData data = converter.convertToDataObject(name, professionData);
        repository.save(data);
    }
}
