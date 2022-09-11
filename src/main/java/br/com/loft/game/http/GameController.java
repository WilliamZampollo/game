package br.com.loft.game.http;

import br.com.loft.game.exception.ProfessionNotFoundException;
import br.com.loft.game.http.converter.ProfessionConverter;
import br.com.loft.game.usecase.ProfessionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/game")
public class GameController {
    private final ProfessionConverter professionConverter;
    private final ProfessionUseCase professionUseCase;

    @GetMapping("/professions")
    public ResponseEntity getProfessionList(){
        try{
            return ResponseEntity.ok(professionConverter.converterToProfessionList(professionUseCase.getProfessions()));
        }catch (ProfessionNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
