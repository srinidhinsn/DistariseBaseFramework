package com.distarise.credaegis.dao.impl;

import com.distarise.credaegis.dao.PersonDao;
import com.distarise.credaegis.entity.Person;
import com.distarise.credaegis.model.LeadDto;
import com.distarise.credaegis.model.PersonDto;
import com.distarise.credaegis.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    @Override
    public PersonDto findByPid(Long pid) {
        Optional<Person> person = personRepository.findById(pid);
        List<LeadDto> leadDtoList = person.get().getLeadList().stream().map(lead ->
                modelMapper.map(lead, LeadDto.class)).toList();
        PersonDto personDto = modelMapper.map(person.get(), PersonDto.class);
        personDto.setLeadDtoList(leadDtoList);
        return personDto;
    }
}
