package com.distarise.credaegis.dao.impl;

import com.distarise.credaegis.dao.PersonDao;
import com.distarise.credaegis.entity.Person;
import com.distarise.credaegis.model.PersonDto;
import com.distarise.credaegis.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonDaoImpl implements PersonDao {

    @Autowired
    PersonRepository personRepository;

    @Override
    public PersonDto save(PersonDto personDto) {
        Person person = modelMapper.map(personDto, Person.class);
        personRepository.save(person);
        personDto.setPid(person.getPid());
        return personDto;
    }
}
