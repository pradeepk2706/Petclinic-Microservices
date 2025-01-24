package org.spring.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.spring.petclinic.model.NamedEntity;

/**
 */
@Entity
@Table(name = "types")
public class PetType extends NamedEntity {

}
