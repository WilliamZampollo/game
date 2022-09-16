package br.com.loft.game.gateway.data;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "personage")
public class PersonageData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    public String name;

    @Column(name = "alive")
    public boolean alive;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "profession_id", nullable = false)
    private ProfessionData profession;

}
