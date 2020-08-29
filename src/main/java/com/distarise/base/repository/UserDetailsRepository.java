package com.distarise.base.repository;

import com.distarise.base.entity.UserDetails;
import com.distarise.base.entity.UserId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, UserId> {

    @Query("select u from UserDetails u where u.userId = :userId and u.password=:password and u.clientId =:clientId")
    UserDetails getUserDetails(@Param("userId") String userId, @Param("userId") String password,
                               @Param("clientid")String clientId);

}