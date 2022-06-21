package com.example.kejani_backend.UtilitiesManagement.services;
import com.example.kejani_backend.Usermanagement.entities.HouseOwner;
import com.example.kejani_backend.Usermanagement.repositories.UserManagementRepository;
import com.example.kejani_backend.UtilitiesManagement.models.HouseUtility;
import com.example.kejani_backend.UtilitiesManagement.repositories.BillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillCreationService {
    @Autowired
    private final BillsRepository billsRepository;

    public BillCreationService(BillsRepository billsRepository) {
        this.billsRepository = billsRepository;
    }

    public void createUser(HouseUtility houseUtility) {
        billsRepository.save(houseUtility);
    }
}
