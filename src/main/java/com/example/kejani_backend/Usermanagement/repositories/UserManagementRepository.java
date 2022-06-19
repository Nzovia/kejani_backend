package com.example.kejani_backend.Usermanagement.repositories;

import com.example.kejani_backend.Usermanagement.entities.HouseOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserManagementRepository extends JpaRepository<HouseOwner, Long> {
    void findByEmail(String email);

    void findByMobileNumber(String mobileNumber);
}
