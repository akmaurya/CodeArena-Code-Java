package com.mydocument.service;

import java.util.List;

import com.mydocument.dto.PersonDTO;
import com.mydocument.model.Person;

public interface PersonService {

    List<Person> getAllPerson();

//    Person getPersonById(Long id);

    Person createPerson(PersonDTO personDTO);

//    Person updatePerson(Long id, PersonDTO personDTO);

//    boolean deletePerson(Long id);

	Person getPersonByName(String name);

	boolean deletePerson(String name);

	Person updatePerson(String name, PersonDTO personDTO);
}