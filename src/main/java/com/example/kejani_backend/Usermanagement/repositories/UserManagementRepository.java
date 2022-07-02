package com.example.kejani_backend.Usermanagement.repositories;

import com.example.kejani_backend.Usermanagement.entities.HouseOwner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserManagementRepository extends JpaRepository<HouseOwner, Long> {


    Optional<HouseOwner> findByEmail(String emailAddress);

    Optional<HouseOwner> findByMobileNumber(String mobileNumber);
}
