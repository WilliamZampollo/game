package br.com.loft.game.entity;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class Profession {
    private Integer id;
    private String name;
    private Integer lifePoints;
    private Integer power;
    private Integer skill;
    private Integer intelligence;
    private Integer attack;
    private String attackDescription;
    private Integer velocity;
    private String velocityDescription;
}
