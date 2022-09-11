package br.com.loft.game.usecase.impl;

import br.com.loft.game.entity.Profession;
import br.com.loft.game.gateway.ProfessionGateway;
import br.com.loft.game.usecase.ProfessionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProfessionUseCaseImpl implements ProfessionUseCase {

    private final ProfessionGateway professionGateway;

    @Override
    public List<Profession> getProfessions() {
        return professionGateway.getProfessions();
    }
}
