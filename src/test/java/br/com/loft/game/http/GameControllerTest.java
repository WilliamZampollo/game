package br.com.loft.game.http;

import br.com.loft.game.entity.Profession;
import br.com.loft.game.exception.CreatePersonageWithoutProfessionException;
import br.com.loft.game.exception.ProfessionNotFoundException;
import br.com.loft.game.http.converter.ProfessionConverter;
import br.com.loft.game.http.data.response.ProfessionResponse;
import br.com.loft.game.usecase.PersonageUseCase;
import br.com.loft.game.usecase.ProfessionUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static br.com.loft.game.mock.ProfessionMock.getProfession;
import static br.com.loft.game.mock.ProfessionMock.getProfessionResponse;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    @MockBean
    private PersonageUseCase personageUseCase;

    @Test
    public void findAllProfessions() throws Exception {
        Profession profession = getProfession();
        ProfessionResponse professionResponse = getProfessionResponse();
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

    @Test
    public void postPersonage() throws Exception {
        doNothing().when(personageUseCase).createPersonage(any(), any());
        this.mockMvc.perform(post("/game/personage")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content("""
                                {
                                    "name": "UserTest",
                                    "professionId": 3
                                }"""))
                .andExpect(status().isNoContent());
    }

    @Test
    public void postPersonageWithoutBody() throws Exception {
        doNothing().when(personageUseCase).createPersonage(any(), any());
        this.mockMvc.perform(post("/game/personage")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void postPersonageWithWrongProfession() throws Exception {
        doThrow(new CreatePersonageWithoutProfessionException()).when(personageUseCase).createPersonage(any(), any());
        this.mockMvc.perform(post("/game/personage")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content("""
                                {
                                    "name": "UserTest",
                                    "professionId": 10
                                }"""))
                .andExpect(status().isPreconditionFailed());
    }

}
