package com.distarise.credaegis.repository;

import com.distarise.credaegis.entity.Lead;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadRepository extends CrudRepository<Lead, Long> {
    List<Lead> findByPid(Long pid);
}
