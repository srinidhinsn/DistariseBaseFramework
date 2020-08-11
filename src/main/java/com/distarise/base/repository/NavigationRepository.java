package com.distarise.base.repository;

import com.distarise.base.entity.Navigation;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NavigationRepository extends CrudRepository<Navigation, String>  {

    @Query("from Navigation where clientId = ?1 and module = ?2 and roleName in (?3)")
    Navigation getNavigationDetails(String clientId, String module, List<String> roleNames);

    @Query("from Navigation where clientId = ?1 and module = ?2 and roleName is null")
    Navigation getNavigationDetails(String clientId, String module);
}
