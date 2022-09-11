package br.com.loft.game.config;

import br.com.loft.game.gateway.data.ProfessionData;
import br.com.loft.game.gateway.repository.ProfessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final ProfessionRepository repository;

    public void run(ApplicationArguments args) {
        repository.save(new ProfessionData(1L,"Warrior", 20, 10, 5, 5, 9, "80% da Força + 20% da Destreza", 4, "60% da Destreza + 20% da Inteligência"));
        repository.save(new ProfessionData(2L,"Thief", 15, 4, 10, 4, 12, "25% da Força + 100% da Destreza + 25% da Inteligência", 8, "80% da Destreza"));
        repository.save(new ProfessionData(3L, "Mage", 12, 5, 6, 10, 19, "20% da Força + 50% da Destreza + 150% da Inteligência", 4, "20% da Força + 50% da Destreza"));

    }
}
