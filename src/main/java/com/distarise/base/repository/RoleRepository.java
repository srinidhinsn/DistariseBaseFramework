package com.distarise.base.repository;

import com.distarise.base.entity.Role;
import com.distarise.base.entity.RoleId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, RoleId> {
    @Query("from Role where clientId = ?1 order by roleName")
    List<Role> findByClientId(String client);
}
