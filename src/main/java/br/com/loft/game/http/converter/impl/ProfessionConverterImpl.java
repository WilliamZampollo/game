package br.com.loft.game.http.converter.impl;

import br.com.loft.game.entity.Profession;
import br.com.loft.game.http.converter.ProfessionConverter;
import br.com.loft.game.http.data.response.ProfessionResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProfessionConverterImpl implements ProfessionConverter {

    @Override
    public List<ProfessionResponse> converterToProfessionList(List<Profession> professions) {
        List<ProfessionResponse> convertedList = new ArrayList<>();
        professions.forEach(p -> convertedList.add(
                ProfessionResponse.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .lifePoints(p.getLifePoints())
                        .power(p.getPower())
                        .skill(p.getSkill())
                        .intelligence(p.getIntelligence())
                        .attack(p.getAttack())
                        .attackDescription(p.getAttackDescription())
                        .velocity(p.getVelocity())
                        .velocityDescription(p.getVelocityDescription())
                        .build()));
        return convertedList;
    }
}
