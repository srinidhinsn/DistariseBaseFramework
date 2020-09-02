package com.distarise.base.repository;

import com.distarise.base.entity.RoleWidgetAction;
import com.distarise.base.entity.UserRole;
import com.distarise.base.entity.UserRoleId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, UserRoleId> {

    @Query("select rwa from RoleWidgetAction rwa where rwa.roleName in " +
            "(select u.roleName from UserRole u where u.userId = :userId and u.clientId =:clientId) "+
            "and rwa.clientId=:clientId and rwa.visible = true")
    List<RoleWidgetAction> getUserRoleWidgetActions(@Param("userId") String userId, @Param("clientId") String clientId);

    @Query("select u from UserRole u where u.userId = :userId and u.clientId =:clientId")
    List<UserRole> getUserRole(@Param("userId") String userId, @Param("clientId") String clientId);

}