package br.com.loft.game.gateway.converter.impl;

import br.com.loft.game.entity.Profession;
import br.com.loft.game.gateway.converter.ProfessionGatewayConverter;
import br.com.loft.game.gateway.data.ProfessionData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProfessionGatewayConverterImpl implements ProfessionGatewayConverter {

    @Override
    public List<Profession> converterToProfessionList(List<ProfessionData> professions) {
        List<Profession> convertedList = new ArrayList<>();
        professions.forEach(p -> convertedList.add(converterToProfession(p)));

        return convertedList;
    }

    @Override
    public ProfessionData convertToDataObject(Profession profession) {
        return ProfessionData.builder()
                .id(profession.getId().longValue())
                .name(profession.getName())
                .lifePoints(profession.getLifePoints())
                .power(profession.getPower())
                .skill(profession.getSkill())
                .intelligence(profession.getIntelligence())
                .attack(profession.getAttack())
                .attackDescription(profession.getAttackDescription())
                .velocity(profession.getVelocity())
                .velocityDescription(profession.getVelocityDescription())
                .build();
    }

    @Override
    public Profession converterToProfession(ProfessionData profession) {
        return Profession.builder()
                .id(profession.getId().intValue())
                .name(profession.getName())
                .lifePoints(profession.getLifePoints())
                .power(profession.getPower())
                .skill(profession.getSkill())
                .intelligence(profession.getIntelligence())
                .attack(profession.getAttack())
                .attackDescription(profession.getAttackDescription())
                .velocity(profession.getVelocity())
                .velocityDescription(profession.getVelocityDescription())
                .build();
    }
}
