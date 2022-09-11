package br.com.loft.game.gateway.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profession")
public class ProfessionData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "life_points")
    public Integer lifePoints;

    @Column(name = "power")
    public Integer power;

    @Column(name = "skill")
    public Integer skill;

    @Column(name = "intelligence")
    public Integer intelligence;

    @Column(name = "attack")
    public Integer attack;

    @Column(name = "attack_description")
    public String attackDescription;

    @Column(name = "velocity")
    public Integer velocity;

    @Column(name = "velocity_description")
    public String velocityDescription;
}
