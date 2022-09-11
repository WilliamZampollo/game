package br.com.loft.game.http;

import br.com.loft.game.entity.Profession;
import br.com.loft.game.exception.ProfessionNotFoundException;
import br.com.loft.game.http.converter.ProfessionConverter;
import br.com.loft.game.http.data.response.ProfessionResponse;
import br.com.loft.game.usecase.ProfessionUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = GameController.class)
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProfessionConverter professionConverter;
    @MockBean
    private ProfessionUseCase professionUseCase;

    @Test
    public void findAllProfessions() throws Exception {
        Profession profession = new Profession(1,"Manager", 10, 11, 12, 13, 14, "Attack", 16, "Velocity");
        ProfessionResponse professionResponse = new ProfessionResponse(1,"Manager", 10, 11, 12, 13, 14, "Attack", 16, "Velocity");
        List<Profession> professions = List.of(profession);
        List<ProfessionResponse> professionsResponseList = List.of(professionResponse);

        when(professionUseCase.getProfessions()).thenReturn(professions);
        when(professionConverter.converterToProfessionList(any())).thenReturn(professionsResponseList);

        this.mockMvc.perform(get("/game/professions"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Manager")));
    }

    @Test
    public void notFoundProfessions() throws Exception {
        when(professionUseCase.getProfessions()).thenThrow(new ProfessionNotFoundException("Nenhuma profissão encontrada."));

        this.mockMvc.perform(get("/game/professions"))
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("Nenhuma profissão encontrada.")));
    }

}
