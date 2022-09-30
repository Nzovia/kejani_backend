package com.example.kejani_backend.utilitiesManagement.repositories;
import com.example.kejani_backend.utilitiesManagement.models.HouseBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillsRepository extends JpaRepository<HouseBill,Long> {

}
