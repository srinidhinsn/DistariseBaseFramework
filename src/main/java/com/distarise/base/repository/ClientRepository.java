package com.distarise.base.repository;

import com.distarise.base.entity.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, String> {

    @Query("from Client where id = ?1")
    Client getClientDetails(String clientId);
}
