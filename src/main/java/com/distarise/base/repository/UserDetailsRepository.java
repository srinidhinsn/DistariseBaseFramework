package com.distarise.base.repository;

import com.distarise.base.entity.UserDetails;
import com.distarise.base.entity.UserId;
import com.distarise.base.model.UserDetailsDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, UserId> {

    @Query("select u from UserDetails u where u.userId = :userId and u.password=:password and u.clientId =:clientId")
    UserDetails getUserDetails(@Param("userId") String userId, @Param("password") String password,
                               @Param("clientId")String clientId);

    @Query("from UserDetails u where u.clientId =:clientId")
    List<UserDetails> getAllUserByClientId(@Param("clientId")String clientId);
}