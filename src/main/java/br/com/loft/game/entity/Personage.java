package br.com.loft.game.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Personage {
    private Integer id;
    private Integer professionId;
    private String name;
    public Integer lifePoints;
    public Integer power;
    public Integer skill;
    public Integer intelligence;
    public Integer attack;
    public String attackDescription;
    public Integer velocity;
    public String velocityDescription;
}
