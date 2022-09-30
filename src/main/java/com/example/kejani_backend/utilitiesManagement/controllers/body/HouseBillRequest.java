package com.example.kejani_backend.utilitiesManagement.controllers.body;

import com.example.kejani_backend.utilitiesManagement.enums.BillPriority;
import com.example.kejani_backend.utilitiesManagement.enums.BillStatus;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class HouseBillRequest {
    @NotNull
    private Long userId;
    @NotNull
    private String billName;
    @NotNull
    private String billLogo;
    @NotNull
    private LocalDate paymentDate;
    @NotNull
    private int billBalance;
    @NotNull
    private int billAmount;
    private BillStatus billStatus;
    private BillPriority billPriority;
}
