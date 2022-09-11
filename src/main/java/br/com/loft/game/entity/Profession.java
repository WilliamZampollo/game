package br.com.loft.game.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Profession {
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
