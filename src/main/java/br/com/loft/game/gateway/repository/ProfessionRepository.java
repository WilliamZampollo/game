package br.com.loft.game.gateway.repository;

import br.com.loft.game.gateway.data.ProfessionData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionRepository extends JpaRepository<ProfessionData, Long> {
}
