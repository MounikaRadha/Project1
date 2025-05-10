package com.RadhaMounika.backend.repository;

import com.RadhaMounika.backend.modals.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
     //check if user exists with this email address
     boolean existsUserByUserEmailAddress(String userEmailAddress);
}
