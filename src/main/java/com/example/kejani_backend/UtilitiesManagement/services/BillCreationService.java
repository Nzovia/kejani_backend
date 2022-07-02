package com.example.kejani_backend.UtilitiesManagement.services;
import com.example.kejani_backend.Usermanagement.entities.HouseOwner;
import com.example.kejani_backend.Usermanagement.repositories.UserManagementRepository;
import com.example.kejani_backend.UtilitiesManagement.models.HouseUtility;
import com.example.kejani_backend.UtilitiesManagement.repositories.BillsRepository;
import com.example.kejani_backend.cardmanagement.entities.Cards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class BillCreationService {
    @Autowired
    private final BillsRepository billsRepository;

    public BillCreationService(BillsRepository billsRepository) {
        this.billsRepository = billsRepository;
    }

    public void createUser(HouseUtility houseUtility) {
        var billLevel = houseUtility.getBillStatus();
        switch (billLevel){
            case PENDING:
                if((houseUtility.getPaymentDate() == LocalDate.now()) && (houseUtility.getBillBalance() != 0)){
//                    if(houseUtility.getAmount() <= ){
//                        //TODO: check bill prioty and E-wallet balance
//                    }
                    //TODO: call billPayments service

                }
            case PAID:
                if ((houseUtility.getPaymentDate() == LocalDate.now()) && (houseUtility.getBillBalance() == 0)){

                }
                break;

        }

        billsRepository.save(houseUtility);
    }
}
