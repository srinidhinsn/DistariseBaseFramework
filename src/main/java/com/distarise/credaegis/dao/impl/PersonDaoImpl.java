package com.distarise.credaegis.dao.impl;

import com.distarise.credaegis.dao.PersonDao;
import com.distarise.credaegis.entity.Contact;
import com.distarise.credaegis.entity.Email;
import com.distarise.credaegis.entity.Identity;
import com.distarise.credaegis.entity.Lead;
import com.distarise.credaegis.entity.Person;
import com.distarise.credaegis.model.LeadDto;
import com.distarise.credaegis.model.PersonDto;
import com.distarise.credaegis.repository.PersonRepository;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PersonDaoImpl implements PersonDao {

    @Autowired
    PersonRepository personRepository;

    @Override
    public PersonDto save(PersonDto personDto) {
        Person person = modelMapper.map(personDto, Person.class);
        setInnerObjects(person, personDto);
        personRepository.save(person);
        personDto.setPid(person.getPid());
        return personDto;
    }

    private void setInnerObjects(Person person, PersonDto personDto){
        if (null != personDto.getIdentityList() && !personDto.getIdentityList().isEmpty()) {
            List<Identity> identities = personDto.getIdentityList().stream().map(identityDto ->
                    modelMapper.map(identityDto, Identity.class)).collect(Collectors.toList());
            person.setIdentityList(identities);
        }
        if (null != personDto.getLeadDtoList() && !personDto.getLeadDtoList().isEmpty()){
            List<Lead> leads = personDto.getLeadDtoList().stream().map(leadDto ->
                    modelMapper.map(leadDto, Lead.class)).collect(Collectors.toList());
            person.setLeadList(leads);
        }
        if (null != personDto.getContactList() && !personDto.getContactList().isEmpty()) {
            List<Contact> contacts = personDto.getContactList().stream().map(contactDto ->
                    modelMapper.map(contactDto, Contact.class)).collect(Collectors.toList());
            person.setContactList(contacts);
        }
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
