package com.example.kejani_backend.utilitiesManagement.repositories;
import com.example.kejani_backend.utilitiesManagement.models.HouseUtility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillsRepository extends JpaRepository<HouseUtility,Long> {

}
