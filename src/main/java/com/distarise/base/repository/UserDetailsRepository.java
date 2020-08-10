package com.distarise.base.repository;

import com.distarise.base.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, String> {

    @Query("select u from UserDetails u where u.userId = :userId")
    UserDetails getUserDetails(@Param("userId") String userId);

    UserDetails findUserDetailsByUserId(String userId);

}