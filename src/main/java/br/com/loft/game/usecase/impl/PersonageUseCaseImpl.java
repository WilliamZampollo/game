package br.com.loft.game.usecase.impl;

import br.com.loft.game.entity.Profession;
import br.com.loft.game.exception.CreatePersonageWithoutProfessionException;
import br.com.loft.game.exception.ProfessionNotFoundException;
import br.com.loft.game.gateway.PersonageGateway;
import br.com.loft.game.usecase.PersonageUseCase;
import br.com.loft.game.usecase.ProfessionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonageUseCaseImpl implements PersonageUseCase {

    private final ProfessionUseCase professionUseCase;
    private final PersonageGateway personageGateway;

    @Override
    public void createPersonage(String name, Integer professionId) {
        try {
            Profession profession = professionUseCase.findById(professionId);

            personageGateway.createPersonage(name, profession);

        }catch (ProfessionNotFoundException e){
            throw new CreatePersonageWithoutProfessionException("Erro ao criar personagem, profissão informada não existente.");
        }
    }
}
