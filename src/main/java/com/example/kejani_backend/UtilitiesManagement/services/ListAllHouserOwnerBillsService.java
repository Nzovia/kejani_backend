package com.example.kejani_backend.UtilitiesManagement.services;
import com.example.kejani_backend.UtilitiesManagement.models.HouseUtility;
import com.example.kejani_backend.UtilitiesManagement.repositories.BillsRepository;
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


    public List<HouseUtility> displayAllBills() {
        return billsRepository.findAll();
    }
}
