package br.com.loft.game.gateway.impl;

import br.com.loft.game.entity.Profession;
import br.com.loft.game.exception.ProfessionNotFoundException;
import br.com.loft.game.gateway.ProfessionGateway;
import br.com.loft.game.gateway.converter.ProfessionGatewayConverter;
import br.com.loft.game.gateway.data.ProfessionData;
import br.com.loft.game.gateway.repository.ProfessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProfessionGatewayImpl implements ProfessionGateway {

    private final ProfessionRepository professionRepository;
    private final ProfessionGatewayConverter converter;
    @Override
    public List<Profession> getProfessions() {
        List<ProfessionData> professions = professionRepository.findAll();

        if(professions.isEmpty()){
            throw new ProfessionNotFoundException("Nenhuma profissão encontrada.");
        }

        return converter.converterToProfessionList(professions);
    }

    @Override
    public Boolean existsById(Integer id) {
        return professionRepository.existsById(id.longValue());
    }

    @Override
    public Profession findById(Integer id) {
        Optional<ProfessionData> profession = professionRepository.findById(id.longValue());

        if(profession.isEmpty()){
            throw new ProfessionNotFoundException("Nenhuma profissão encontrada.");
        }

        return converter.converterToProfession(profession.get());
    }
}
