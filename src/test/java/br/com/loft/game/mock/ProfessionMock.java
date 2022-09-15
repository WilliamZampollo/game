package br.com.loft.game.mock;

import br.com.loft.game.entity.Profession;
import br.com.loft.game.gateway.data.ProfessionData;
import br.com.loft.game.http.data.response.ProfessionResponse;

public class ProfessionMock {
    public static Profession getProfession(){
        return new Profession(1,"Manager", 10, 11, 12, 13, 14, "Attack", 16, "Velocity");
    }

    public static ProfessionData getProfessionData(){
        return new ProfessionData(1L,"Manager", 10, 11, 12, 13, 14, "Attack", 16, "Velocity",null);
    }

    public static ProfessionResponse getProfessionResponse(){
        return new ProfessionResponse(1,"Manager", 10, 11, 12, 13, 14, "Attack", 16, "Velocity");
    }
}
