package org.spring.rest.petclinic.visit;

import java.util.List;

import org.spring.rest.petclinic.model.BaseEntity;
import org.spring.rest.petclinic.model.Visit;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "visit", path = "visit")

public interface VisitRepository extends PagingAndSortingRepository<Visit, Integer> {

    List<Visit> findByPetId(Integer petId);

}
