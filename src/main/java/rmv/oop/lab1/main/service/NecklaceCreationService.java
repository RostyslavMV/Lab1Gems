package rmv.oop.lab1.main.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rmv.oop.lab1.main.model.Gem;
import rmv.oop.lab1.main.model.Necklace;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class NecklaceCreationService {
    private final GemMiningService gemMiningService;
    private final GemEvaluationService gemEvaluationService;

    public Necklace createNecklace(Integer gemCount) {
        List<Gem> gems = new ArrayList<>();

        for (int i = 0; i < gemCount; i++) {
            gems.add(gemMiningService.mineGem());
        }
        BigDecimal price = getNecklacePrice(gems);
        BigDecimal weight = getNecklaceWeight(gems);
        return new Necklace(gems,price,weight);
    }

    public BigDecimal getNecklacePrice(List<Gem> gems) {
        return gems.stream()
                .map(gemEvaluationService::evaluatePrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public BigDecimal getNecklaceWeight(List<Gem> gems) {
        return gems.stream()
                .map(Gem::getWeight)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
