package br.com.loft.game.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionNotFoundException extends RuntimeException {
    private String message;
}
