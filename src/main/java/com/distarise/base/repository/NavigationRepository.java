package com.distarise.base.repository;

import com.distarise.base.entity.Navigation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NavigationRepository extends CrudRepository<Navigation, String>  {

    @Query("from Navigation where clientId = ?1 and module = ?2 and roleName =?3")
    Navigation getNavigationDetails(String clientId, String module, String roleName);

    @Query("from Navigation where clientId = ?1 and module = ?2 and roleName is null")
    Navigation getNavigationDetails(String clientId, String module);

    @Query("from Navigation where clientId = ?1")
    List<Navigation> getAllNavigations(String clientId);
}
