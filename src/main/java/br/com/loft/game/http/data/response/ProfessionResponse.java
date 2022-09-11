package br.com.loft.game.http.data.response;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionResponse {
    private Integer id;
    public String name;
    public Integer lifePoints;
    public Integer power;
    public Integer skill;
    public Integer intelligence;
    public Integer attack;
    public String attackDescription;
    public Integer velocity;
    public String velocityDescription;
}
