package org.spring.petclinic.owner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.petclinic.model.Pet;
import org.spring.petclinic.model.Visit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RestController
class OwnerController {

    @Value("#{environment['SERVICE_ENDPOINT'] ?: 'localhost:8080'}")
    private String serviceEndpoint;

    @Inject
    private OwnerRepository owners;
    private static final Logger logger = LoggerFactory.getLogger(OwnerController.class);

    @RequestMapping(value = "/owner/{ownerId}/getVisits", method = RequestMethod.GET)
    public ResponseEntity<List<Visit>> getOwnerVisits(@PathVariable int ownerId){
        List<Pet> petList = this.owners.findById(ownerId).getPets();
        List<Visit> visitList = new ArrayList<Visit>();
        petList.forEach(pet -> {
            logger.info(getPetVisits(pet.getId()).toString());
            visitList.addAll(getPetVisits(pet.getId()));
        });
        return new ResponseEntity<List<Visit>>(visitList, HttpStatus.OK);
    }

    private List<Visit> getPetVisits(int petId){
        List<Visit> visitList = new ArrayList<Visit>();
        RestTemplate restTemplate = new RestTemplate();
        Pet pet = restTemplate.getForObject("http://"+serviceEndpoint+"/pet/"+petId, Pet.class);
        logger.info(pet.getVisits().toString());
        return pet.getVisits();
    }
}
