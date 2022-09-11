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
        professions.forEach(p -> convertedList.add(
                Profession.builder()
                        .id(p.getId().intValue())
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
