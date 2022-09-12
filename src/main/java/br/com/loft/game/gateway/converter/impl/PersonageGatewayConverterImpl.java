package br.com.loft.game.gateway.converter.impl;

import br.com.loft.game.gateway.converter.PersonageGatewayConverter;
import br.com.loft.game.gateway.data.PersonageData;
import br.com.loft.game.gateway.data.ProfessionData;
import org.springframework.stereotype.Component;

@Component
public class PersonageGatewayConverterImpl implements PersonageGatewayConverter {

    @Override
    public PersonageData convertToDataObject(String name, ProfessionData profession) {
        return PersonageData.builder()
                .name(name)
                .profession(profession)
                .build();
    }
}
