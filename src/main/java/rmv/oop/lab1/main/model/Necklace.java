package rmv.oop.lab1.main.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Necklace {
    private List<Gem> gems;
    private BigDecimal price;
    private BigDecimal weight;

    public void print() {
        System.out.println("Necklace price = " + price);
        System.out.println("Neclace weight = " + weight);
        System.out.println("Necklace contains these gems:");
        for (Gem gem : gems) {
            System.out.println(gem);
        }
    }
}
