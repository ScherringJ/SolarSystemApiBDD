package spring.scherring.solarsytembddapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import spring.scherring.solarsytembddapi.dao.PlaneteRepository;
import spring.scherring.solarsytembddapi.model.Planete;

@SpringBootApplication
public class SolarSytemBddApiApplication {

   private static final Logger log = LoggerFactory.getLogger(SolarSytemBddApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SolarSytemBddApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(PlaneteRepository planeteRepository) {
        return (args) -> {
            planeteRepository.save(new Planete(1, "Venus", "Antiquite", "Tellurique"));
            planeteRepository.save(new Planete(2, "Jupiter", "Antiquite", "Gazeuse"));
            planeteRepository.save(new Planete(3, "Mars", "Antiquite", "Tellurique"));
            planeteRepository.save(new Planete(4, "Saturn", "Antiquite", "Gazeuse"));


            log.info("Affichage de toute les planètes ------- (findAll) --------");
            for (Planete planete : planeteRepository.findAll()) {
                log.info(planete.toString());
            }

             log.info("Affichage d'une seul photo ------- (findByID) --------");
             Planete planete = planeteRepository.findById(2);
             log.info(planete.toString());
        };
    }
}
