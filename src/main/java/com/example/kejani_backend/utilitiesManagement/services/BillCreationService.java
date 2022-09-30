package com.example.kejani_backend.utilitiesManagement.services;
import com.example.kejani_backend.utilitiesManagement.controllers.body.HouseBillRequest;
import com.example.kejani_backend.utilitiesManagement.models.HouseBill;
import com.example.kejani_backend.utilitiesManagement.repositories.BillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillCreationService {
    @Autowired
    private final BillsRepository billsRepository;

    public BillCreationService(BillsRepository billsRepository) {
        this.billsRepository = billsRepository;
    }

    public void createBill(HouseBillRequest request) {
        var bill = new HouseBill();
        bill.setBillName(request.getBillName());

        //check bill status, if unpaid compute total balance depending on bill amount
        bill.setBillBalance(request.getBillBalance());
        bill.setBillStatus(request.getBillStatus());
        bill.setBillLogo(request.getBillLogo());
        bill.setPaymentDate(request.getPaymentDate());
        bill.setBillStatus(request.getBillStatus());
        bill.setBillPriority(request.getBillPriority());

       billsRepository.save(bill);
    }
}
