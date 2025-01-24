package org.spring.rest.petclinic.visit;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitController {

    /*private final VisitRepository visits;
    private final PetRepository pets;


    public VisitRepository getVisits() {
        return visits;
    }

    @Autowired
    public VisitController(VisitRepository visits, PetRepository pets) {
        this.visits = visits;
        this.pets = pets;
    }

    // Spring MVC calls method loadPetWithVisit(...) before processNewVisitForm is called
    @RequestMapping(value = "/owners/{ownerId}/pets/{petId}/visits/", method = RequestMethod.POST)
    public void addVisit(Visit visit) {
        this.visits.save(visit);
    }*/

}
