package rmv.oop.lab1.main.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Diamond extends Gem {
    private DiamondColor color;

    public Diamond(DiamondColor color, BigDecimal clarity, BigDecimal weight) {
        super(clarity, weight);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Diamond{" +
                "weight=" + super.getWeight() + " " +
                " clarity=" + super.getClarity() + " " +
                " price=" + super.getPrice() + " " +
                " color=" + color +
                '}';
    }
}
