package br.com.loft.game.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
@Getter
@Builder
@AllArgsConstructor
public class Personage {
    private Integer id;
    private Integer professionId;
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
