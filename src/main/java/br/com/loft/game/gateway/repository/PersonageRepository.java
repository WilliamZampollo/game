package br.com.loft.game.gateway.repository;

import br.com.loft.game.gateway.data.PersonageData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonageRepository extends JpaRepository<PersonageData, Long> {
}
