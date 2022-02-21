package nl.hsleiden.DAO.repository;

import nl.hsleiden.model.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface VacationRepository
        extends JpaRepository<Vacation, Long> {

    @Query("SELECT v FROM Vacation v WHERE v.city =?1")
    Optional<Vacation> findVacationByCity(String city);
}
