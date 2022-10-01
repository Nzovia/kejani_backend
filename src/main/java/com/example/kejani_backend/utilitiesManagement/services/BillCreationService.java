package com.example.kejani_backend.utilitiesManagement.services;

import com.example.kejani_backend.usermanagement.entities.HouseOwner;
import com.example.kejani_backend.usermanagement.repositories.UserManagementRepository;
import com.example.kejani_backend.utilitiesManagement.controllers.body.HouseBillRequest;
import com.example.kejani_backend.utilitiesManagement.models.HouseBill;
import com.example.kejani_backend.utilitiesManagement.repositories.BillsRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.*;

@Service
public class BillCreationService {
    @Autowired
    private final BillsRepository billsRepository;
    private final UserManagementRepository userManagementRepository;

    public BillCreationService(BillsRepository billsRepository, UserManagementRepository userManagementRepository) {
        this.billsRepository = billsRepository;
        this.userManagementRepository = userManagementRepository;
    }

    @SneakyThrows
    public HouseBill createBill(Long userId, HouseBillRequest request) {
        HouseOwner houseOwner = new HouseOwner();
        //setting a list of bills to the houseOwner
        List<HouseBill> bills = new ArrayList<>();

        HouseBill bill = new HouseBill();

        var user = userManagementRepository.findByUserId(userId);
        if(!user.isPresent()){
            throw new NoSuchElementException();
        }
        houseOwner = user.get();

        //setHouseOwner to the bill
        bill.setHouseOwner(houseOwner);
        bill.setBillName(request.getBillName());
            //check bill status, if unpaid compute total balance depending on bill amount
        bill.setBillBalance(request.getBillBalance());
        bill.setBillStatus(request.getBillStatus());
        bill.setBillLogo(request.getBillLogo());
        bill.setPaymentDate(request.getPaymentDate());
        bill.setBillStatus(request.getBillStatus());
        bill.setBillPriority(request.getBillPriority());

        HouseBill bill1 =billsRepository.save(bill);

        bills.add(bill1);
        houseOwner.setHouseBill(bills);

        return bill1;

    }

}
