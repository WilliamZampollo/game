package br.com.loft.game.http.converter.impl;

import br.com.loft.game.entity.Personage;
import br.com.loft.game.http.converter.PersonageConverter;
import br.com.loft.game.http.data.response.SimplePersonageResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonageConverterImpl implements PersonageConverter {

    @Override
    public List<SimplePersonageResponse> convertToListOfSimplePersonageResponse(List<Personage> personageList) {
        List<SimplePersonageResponse> convertedList = new ArrayList<>();
        personageList.forEach(p -> convertedList.add(converterToSimplePersonage(p)));
        return convertedList;
    }

    private SimplePersonageResponse converterToSimplePersonage(Personage p) {
        return SimplePersonageResponse.builder()
                                        .id(p.getId())
                                        .name(p.getName())
                                        .professionName(p.getProfession().getName())
                                        .alive(p.isAlive())
                                        .build();
    }
}
