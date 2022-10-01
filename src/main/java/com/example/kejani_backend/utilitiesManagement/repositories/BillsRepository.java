package com.example.kejani_backend.utilitiesManagement.repositories;
import com.example.kejani_backend.usermanagement.entities.HouseOwner;
import com.example.kejani_backend.utilitiesManagement.models.HouseBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BillsRepository extends JpaRepository<HouseBill,Long> {
}
