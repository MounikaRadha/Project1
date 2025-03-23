package com.m0wn1la.app2.repository;

import com.m0wn1la.app2.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    @Query("select count(u) from users u where u.userName = :username")
    Integer checkUserExistence(@Param("username") String username);

    @Query("select u from users u order by u.id desc")
    Page<User> findAllOrderById(Pageable pageable);
}
