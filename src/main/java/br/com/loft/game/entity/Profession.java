package br.com.loft.game.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Profession {
    private int id;
    private String name;
    private int lifePoints;
    private int power;
    private int skill;
    private int intelligence;
    private int attack;
    private String attackDescription;
    private int velocity;
    private String velocityDescription;
}
