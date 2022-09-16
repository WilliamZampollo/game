package br.com.loft.game.gateway.converter;

import br.com.loft.game.entity.Personage;
import br.com.loft.game.gateway.data.PersonageData;
import br.com.loft.game.gateway.data.ProfessionData;

import java.util.List;

public interface PersonageGatewayConverter {
    PersonageData convertToDataObject(String name, boolean alive, ProfessionData profession);
    List<Personage> convertToEntityList(List<PersonageData> personages);
    Personage converterToPersonage(PersonageData p);

}