package br.com.loft.game.http.converter;

import br.com.loft.game.entity.Profession;
import br.com.loft.game.http.data.response.ProfessionResponse;

import java.util.List;

public interface ProfessionConverter {
    List<ProfessionResponse> converterToProfessionList(List<Profession> professions);
}
