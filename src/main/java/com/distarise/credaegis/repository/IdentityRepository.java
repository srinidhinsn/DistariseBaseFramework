package com.distarise.credaegis.repository;

import com.distarise.credaegis.entity.Identity;
import com.distarise.credaegis.entity.Lead;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityRepository extends CrudRepository<Identity, Long> {

}
