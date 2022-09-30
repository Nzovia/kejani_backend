package com.example.kejani_backend.utilitiesManagement.services;
import com.example.kejani_backend.utilitiesManagement.models.HouseBill;
import com.example.kejani_backend.utilitiesManagement.repositories.BillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllHouserOwnerBillsService {

    @Autowired
    private final BillsRepository billsRepository;

    public ListAllHouserOwnerBillsService(BillsRepository billsRepository) {
        this.billsRepository = billsRepository;
    }


    public List<HouseBill> displayAllBills() {
        return billsRepository.findAll();
    }
}
