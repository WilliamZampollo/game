package br.com.loft.game.usecase;

import br.com.loft.game.entity.Personage;

import java.util.List;

public interface PersonageUseCase {
    void createPersonage(String name, Integer professionId);
    List<Personage> getPersonages();
}