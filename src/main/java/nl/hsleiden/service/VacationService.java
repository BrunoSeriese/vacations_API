package nl.hsleiden.service;

import nl.hsleiden.DAO.repository.VacationRepository;
import nl.hsleiden.model.Vacation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VacationService {


    private final VacationRepository vacationRepository;

    @Autowired
    public VacationService(VacationRepository vacationRepository){
        this.vacationRepository = vacationRepository;
    }

    public List<Vacation> getVacations(){
        return vacationRepository.findAll();
    }

    public void addNewVacation(Vacation vacation) {
        Optional<Vacation> vacationByEmail = vacationRepository
                .findVacationByCity(vacation.getCity());
        if (vacationByEmail.isPresent()){
            throw new IllegalStateException("City is already in the system");
        }
        vacationRepository.save(vacation);
    }
    public Vacation getVacation(Long id){
        return vacationRepository.findVacationById(id);
    }



    public void deleteStudent(Long vacationId) {
        boolean exists = vacationRepository.existsById(vacationId);
        if(!exists){
            throw new IllegalStateException
                    ("Vacation with id" + vacationId + " does not exist");
        }
        vacationRepository.deleteById(vacationId);
    }
}
