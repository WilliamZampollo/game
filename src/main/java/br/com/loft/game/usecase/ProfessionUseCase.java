package br.com.loft.game.usecase;


import br.com.loft.game.entity.Profession;
import java.util.List;

public interface ProfessionUseCase {
    List<Profession> getProfessions();
    Profession findById(Integer id);
}
