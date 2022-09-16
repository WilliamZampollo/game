package br.com.loft.game.http.converter;

import br.com.loft.game.entity.Personage;
import br.com.loft.game.http.data.response.SimplePersonageResponse;

import java.util.List;

public interface PersonageConverter {
    List<SimplePersonageResponse> convertToListOfSimplePersonageResponse(List<Personage> personageList);
}
