package com.example.kejani_backend.utilitiesManagement.services;

import com.example.kejani_backend.usermanagement.repositories.UserManagementRepository;
import com.example.kejani_backend.utilitiesManagement.repositories.BillsRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DeleteBillByIdService {

    private final UserManagementRepository userManagementRepository;
    private final BillsRepository billsRepository;

    public DeleteBillByIdService(UserManagementRepository userManagementRepository,
                                 BillsRepository billsRepository) {
        this.userManagementRepository = userManagementRepository;
        this.billsRepository = billsRepository;
    }
    public void deleteDeleteBill(Integer billId){

       // var user = userManagementRepository.findByUserId(userId);
        var bill = billsRepository.findById(billId);

        if(bill.isPresent()){
            billsRepository.deleteById(billId);
        }
        if(!bill.isPresent()){
            throw new NoSuchElementException("The bill with Id" + billId + "not found");
        }
    }
}
