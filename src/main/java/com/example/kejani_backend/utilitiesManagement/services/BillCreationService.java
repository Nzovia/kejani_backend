package com.example.kejani_backend.utilitiesManagement.services;
import com.example.kejani_backend.utilitiesManagement.models.HouseUtility;
import com.example.kejani_backend.utilitiesManagement.repositories.BillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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
