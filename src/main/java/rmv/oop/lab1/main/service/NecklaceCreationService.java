package rmv.oop.lab1.main.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rmv.oop.lab1.main.model.Gem;
import rmv.oop.lab1.main.model.Necklace;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NecklaceCreationService {
    private final GemMiningService gemMiningService;
    private final GemEvaluationService gemEvaluationService;

    @Autowired
    public NecklaceCreationService(GemMiningService gemMiningService, GemEvaluationService gemEvaluationService) {
        this.gemMiningService = gemMiningService;
        this.gemEvaluationService = gemEvaluationService;
    }

    public Necklace createNecklace(Integer gemCount) {
        List<Gem> gems = new ArrayList<>();

        for (int i = 0; i < gemCount; i++) {
            gems.add(gemMiningService.mineGem());
        }
        BigDecimal price = getNecklacePrice(gems);
        BigDecimal weight = getNecklaceWeight(gems);

        gems = gems.stream().sorted(Comparator.
                comparing(Gem::getPrice)).collect(Collectors.toList());

        return new Necklace(gems, price, weight);
    }

    public BigDecimal getNecklacePrice(List<Gem> gems) {
        return gems.stream()
                .map(gem -> gemEvaluationService.evaluatePrice(gem))
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
