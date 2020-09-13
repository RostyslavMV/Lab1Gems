package rmv.oop.lab1.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import rmv.oop.lab1.main.model.Necklace;
import rmv.oop.lab1.main.service.NecklaceCreationService;

@SpringBootApplication
@PropertySource("classpath:gems.properties")
public class Main implements CommandLineRunner {
    @Value("${necklaceGemsCount}")
    private Integer necklaceGemsCount;

    @Autowired
    private NecklaceCreationService necklaceCreationService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args){
        Necklace necklace = necklaceCreationService.createNecklace(necklaceGemsCount);
        necklace.print();
    }
}
