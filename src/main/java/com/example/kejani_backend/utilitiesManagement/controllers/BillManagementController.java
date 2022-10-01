package com.example.kejani_backend.utilitiesManagement.controllers;

import com.example.kejani_backend.utilitiesManagement.controllers.body.HouseBillRequest;
import com.example.kejani_backend.utilitiesManagement.models.HouseBill;
import com.example.kejani_backend.utilitiesManagement.services.BillCreationService;
import com.example.kejani_backend.utilitiesManagement.services.DeleteBillByIdService;
import com.example.kejani_backend.utilitiesManagement.services.ListAllHouserOwnerBillsService;
import com.example.kejani_backend.utilitiesManagement.services.UpdateBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bills")
public class BillManagementController {

    @Autowired
    private final BillCreationService billCreationService;
    private final ListAllHouserOwnerBillsService houserOwnerBillsService;
    private final UpdateBillService updateBillService;
    private final DeleteBillByIdService deleteBillByIdService;

    public BillManagementController(BillCreationService billCreationService,
                                    ListAllHouserOwnerBillsService houserOwnerBillsService,
                                    UpdateBillService updateBillService,
                                    DeleteBillByIdService deleteBillByIdService) {
        this.billCreationService = billCreationService;
        this.houserOwnerBillsService = houserOwnerBillsService;
        this.updateBillService = updateBillService;
        this.deleteBillByIdService = deleteBillByIdService;
    }
    @PostMapping("/add/{userId}")
    public void createUtilityBill(@PathVariable(value = "userId") Long userId
            ,@RequestBody HouseBillRequest houseBillRequest) {
        billCreationService.createBill(userId,houseBillRequest);

    }
    @GetMapping
    public List<HouseBill> displayAllUserBills(){
        return houserOwnerBillsService.displayAllBills();
    }
}
