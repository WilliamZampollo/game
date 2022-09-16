package br.com.loft.game.gateway;

import br.com.loft.game.entity.Personage;
import br.com.loft.game.entity.Profession;

import java.util.List;

public interface PersonageGateway {
    void createPersonage(String name, boolean alive, Profession profession);
    List<Personage> findAllPersonages();
}