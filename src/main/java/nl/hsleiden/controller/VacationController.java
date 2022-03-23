package nl.hsleiden.controller;


import nl.hsleiden.model.User;
import nl.hsleiden.model.Vacation;
import nl.hsleiden.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api")
public class VacationController {

    private final VacationService vacationService;


    @Autowired
    public VacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }


    @GetMapping("vacations")
    public List<Vacation> getVacations() {
        return vacationService.getVacations();
    }


    @PostMapping
    public void registerNewVacation(@RequestBody Vacation vacation) {
        vacationService.addNewVacation(vacation);
    }

    @CrossOrigin
    @DeleteMapping(path = "secure/{vacationId}")
    public void deleteVacation(@PathVariable("vacationId") Long vacationId) {
        vacationService.deleteStudent(vacationId);
    }


}
