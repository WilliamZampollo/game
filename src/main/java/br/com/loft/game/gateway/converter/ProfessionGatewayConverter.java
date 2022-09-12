package br.com.loft.game.gateway.converter;

import br.com.loft.game.entity.Profession;
import br.com.loft.game.gateway.data.ProfessionData;

import java.util.List;

public interface ProfessionGatewayConverter {
    List<Profession> converterToProfessionList(List<ProfessionData> professions);
    ProfessionData convertToDataObject(Profession profession);

    Profession converterToProfession(ProfessionData professionData);
}
