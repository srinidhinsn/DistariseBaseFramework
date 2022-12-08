package com.distarise.credaegis.model;

import java.util.List;

public class CredaegisContextDto {
    private Long pid;
    private List<Long> lids;
    private PersonDto personDto;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public List<Long> getLids() {
        return lids;
    }

    public void setLids(List<Long> lids) {
        this.lids = lids;
    }

    public PersonDto getPersonDto() {
        return personDto;
    }

    public void setPersonDto(PersonDto personDto) {
        this.personDto = personDto;
    }

    private CredaegisContextDto(CredaegisContextBuilder builder){
        this.pid = builder.pid;
        this.lids = builder.lids;
        this.personDto = builder.personDto;
    }

    public static class CredaegisContextBuilder {
        private Long pid;
        private List<Long> lids;
        private PersonDto personDto;
        public CredaegisContextBuilder(Long pid){
            this.pid = pid;
        }

        public CredaegisContextBuilder lids(List<Long> lids){
            this.lids = lids;
            return this;
        }

        public CredaegisContextBuilder personDto(PersonDto personDto){
            this.personDto = personDto;
            return this;
        }
        public CredaegisContextDto build(){
            CredaegisContextDto credaegisContextDto = new CredaegisContextDto(this);
            validateCredaegisContext(credaegisContextDto);
            return credaegisContextDto;
        }

        private void validateCredaegisContext(CredaegisContextDto credaegisContextDto){
            //validation to be done here
        }
    }
}
