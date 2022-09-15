package br.com.loft.game.mock;

import br.com.loft.game.entity.Personage;
import br.com.loft.game.gateway.data.PersonageData;
import br.com.loft.game.http.data.request.PersonageRequest;

import static br.com.loft.game.mock.ProfessionMock.getProfessionData;

public class PersonageMock {

    public static PersonageData getPersonageData(){
        return PersonageData.builder()
                            .id(1L)
                            .name("TestePerson")
                            .profession(getProfessionData())
                            .build();
    }

    public static PersonageRequest getPersonageRequest(){
        PersonageRequest personageRequest = new PersonageRequest();
        personageRequest.setName("TestePerson");
        personageRequest.setProfessionId(1);

        return personageRequest;
    }

    public static Personage getPersonage(){
        return new Personage(1, 1, "Juninho",10, 11, 12, 13, 14, "Attack", 16, "Velocity");
    }
}
