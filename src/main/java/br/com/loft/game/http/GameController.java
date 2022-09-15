package br.com.loft.game.http;

import br.com.loft.game.exception.CreatePersonageWithoutProfessionException;
import br.com.loft.game.exception.ProfessionNotFoundException;
import br.com.loft.game.http.converter.ProfessionConverter;
import br.com.loft.game.http.data.request.PersonageRequest;
import br.com.loft.game.usecase.PersonageUseCase;
import br.com.loft.game.usecase.ProfessionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/game")
public class GameController {
    private final ProfessionConverter professionConverter;
    private final ProfessionUseCase professionUseCase;
    private final PersonageUseCase personageUseCase;

    @GetMapping("/professions")
    public ResponseEntity getProfessionList(){
        try{
            return ResponseEntity.ok(professionConverter.converterToProfessionList(professionUseCase.getProfessions()));
        }catch (ProfessionNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/personage")
    public ResponseEntity createPersonage(@RequestBody @Valid PersonageRequest request){
        try{
            personageUseCase.createPersonage(request.getName(), request.getProfessionId());
            return ResponseEntity.noContent().build();
        }catch (CreatePersonageWithoutProfessionException e){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.getMessage());
        }
    }
}
