package br.com.loft.game.gateway;

import br.com.loft.game.entity.Profession;

public interface PersonageGateway {
    void createPersonage(String name, Profession profession);
}
