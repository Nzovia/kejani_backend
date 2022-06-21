package com.example.kejani_backend.UtilitiesManagement.controllers;

import com.example.kejani_backend.Usermanagement.entities.HouseOwner;
import com.example.kejani_backend.UtilitiesManagement.models.HouseUtility;
import com.example.kejani_backend.UtilitiesManagement.services.BillCreationService;
import com.example.kejani_backend.UtilitiesManagement.services.DeleteBillByIdService;
import com.example.kejani_backend.UtilitiesManagement.services.ListAllHouserOwnerBillsService;
import com.example.kejani_backend.UtilitiesManagement.services.UpdateBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
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
    @PostMapping("/newUtility")
    public void createUtilityBill(@RequestBody HouseUtility houseUtility) {
        billCreationService.createUser(houseUtility);

    }
    @GetMapping
    public List<HouseUtility> displayAllUserBills(){
        return houserOwnerBillsService.displayAllBills();
    }
}
