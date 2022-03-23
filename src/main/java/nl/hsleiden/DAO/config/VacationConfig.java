package nl.hsleiden.DAO.config;

import nl.hsleiden.DAO.repository.VacationRepository;
import nl.hsleiden.model.Vacation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class VacationConfig {



    @Bean
    CommandLineRunner commandLineRunner(VacationRepository vacationRepository) {
        return args -> {

            if (vacationRepository.findAll().size() == 0){
                Vacation sofia  = new Vacation(
                        "Bulgaria",
                        300,
                        "Sofia",
                        1,
                        "This is a beautiful city with amazing nature all around");
                Vacation haag  = new Vacation(
                        "The Netherlands",
                        500,
                        "The Hague",
                        1,
                        "A beautiful and busy place in the Netherlands");
                Vacation montpellier  = new Vacation(
                        "France",
                        800,
                        "Montpellier",
                        1,
                        "A place in France without any worry");
                Vacation kos  = new Vacation(
                        "Greece",
                        250,
                        "Kos",
                        2,
                        "A beautiful island in Greece");
                Vacation kiev  = new Vacation(
                        "Ukraine",
                        350,
                        "Kiev",
                        2,
                        "The most active city in Eastern Europe");
                Vacation riga  = new Vacation(
                        "Latvia",
                        200,
                        "Riga",
                        2,
                        "The epicenter of the Baltics!");
                Vacation marseille = new Vacation(
                        "France",
                        950,
                        "Marseille",
                        3,
                        "The beautiful sunny southern France");
                Vacation rome  = new Vacation(
                        "Italy",
                        450,
                        "Rome",
                        3,
                        "When in Rome...");
                Vacation valencia = new Vacation(
                        "Spain",
                        280,
                        "Valencia",
                        3,
                        "For a sunny beach vacation!");
                Vacation munich  = new Vacation(
                        "Germany",
                        650,
                        "Munich",
                        4,
                        "Home to Bayern Munich!");
                Vacation bucaresti  = new Vacation(
                        "Romania",
                        400,
                        "Bucaresti",
                        4,
                        "Europes emerging city!");
                Vacation berlin  = new Vacation(
                        "Germany",
                        480,
                        "berlin",
                        4,
                        "See the city with an ancient history!");


                vacationRepository.saveAll(List.of(haag,sofia,marseille,montpellier,kiev,kos,riga,rome,valencia,berlin,bucaresti,munich));
            }

        };






    }
}
