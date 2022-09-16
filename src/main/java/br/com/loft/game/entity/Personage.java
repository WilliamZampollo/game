package br.com.loft.game.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
@Getter
@Builder
@AllArgsConstructor
public class Personage {
    private int id;
    private String name;
    private boolean alive;
    private Profession profession;
}
