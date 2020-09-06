package com.distarise.base.repository;

import com.distarise.base.entity.Layout;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LayoutRepository extends CrudRepository<Layout, String> {

    @Query("from Layout where id = ?1")
    Layout getLayoutDetails(String id);
}
