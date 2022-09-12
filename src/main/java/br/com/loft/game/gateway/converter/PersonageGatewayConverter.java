package br.com.loft.game.gateway.converter;

import br.com.loft.game.gateway.data.PersonageData;
import br.com.loft.game.gateway.data.ProfessionData;

public interface PersonageGatewayConverter {
    PersonageData convertToDataObject(String name, ProfessionData profession);
}
