package com.mydocument.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.mydocument.dto.PersonDTO;
import com.mydocument.model.Person;
import com.mydocument.repository.PersonRepository;
import com.mydocument.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepository;
	private final ModelMapper modelMapper;

	public PersonServiceImpl(PersonRepository personRepository, ModelMapper modelMapper) {
		super();
		this.personRepository = personRepository;
		this.modelMapper = modelMapper;
	}

	//All Person
	@Override
	public List<Person> getAllPerson() {
		return personRepository.findAll();
	}

	//Person of Name
	@Override
	public Person getPersonByName(String name) {
		Optional<Person> optionalPerson = personRepository.findById(name);
		return optionalPerson.orElse(null);
	}

	//Create a Person with all details
	@Override
	public Person createPerson(PersonDTO personDTO) {
		boolean isPersonExist = getPersonByName(personDTO.getName()) != null;
		if (!isPersonExist) {
			Person person = modelMapper.map(personDTO, Person.class);
			Person savedPerson = personRepository.save(person);
			return modelMapper.map(savedPerson, Person.class);
		}else
			return null;
	}

	//Update A person
	@Override
	public Person updatePerson(String name, PersonDTO personDTO) {
		Optional<Person> optionalPerson = personRepository.findById(name);
		if (optionalPerson.isPresent()) {
			if(deletePerson(name)) {
				Person person = modelMapper.map(personDTO, Person.class);
				Person savedPerson = personRepository.save(person);
				return modelMapper.map(savedPerson, Person.class);
			}
		}
		return null;
	}

	//Delete a Person
	@Override
	public boolean deletePerson(String name) {
		Optional<Person> optionalPerson = personRepository.findById(name);
		if (optionalPerson.isPresent()) {
			personRepository.delete(optionalPerson.get());
			return true;
		}
		return false;
	}
}