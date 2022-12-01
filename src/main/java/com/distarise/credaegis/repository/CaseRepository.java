package com.distarise.credaegis.repository;

import com.distarise.credaegis.entity.Case;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseRepository extends CrudRepository<Case, String> {

}
