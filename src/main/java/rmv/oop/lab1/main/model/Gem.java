package rmv.oop.lab1.main.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class Gem {
    private BigDecimal clarity;
    private BigDecimal weight; //In carats

}
