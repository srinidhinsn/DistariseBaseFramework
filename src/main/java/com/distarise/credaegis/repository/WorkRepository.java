package com.distarise.credaegis.repository;

import com.distarise.credaegis.entity.Work;
import com.distarise.credaegis.entity.WorkId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkRepository extends CrudRepository<Work, WorkId> {
    List<Work> findByStatusOrderByPidDesc(String status);
    List<Work> findByPid(Long pid);
}
