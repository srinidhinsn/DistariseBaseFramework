package com.distarise.base.repository;

import com.distarise.base.entity.Layout;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LayoutRepository extends CrudRepository<Layout, String> {

    @Query("from Layout")
    List<Layout> getLayoutDetails();
}
