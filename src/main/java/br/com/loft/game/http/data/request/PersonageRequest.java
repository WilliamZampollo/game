package br.com.loft.game.http.data.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonageRequest {

    @NotNull
    @Size(min = 1, max = 15, message = "O nome deve ter no máximo 15 caracteres")
    @Pattern(regexp = "^[A-Za-z_]*$", message = " Um nome só pode ter letras ou o carácter de _ (underscore/sublinhado)")
    private String name;

    @NotNull
    private Integer professionId;
}
