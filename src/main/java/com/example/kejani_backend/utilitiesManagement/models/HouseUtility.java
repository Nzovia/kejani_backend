package com.example.kejani_backend.utilitiesManagement.models;

import com.example.kejani_backend.usermanagement.entities.HouseOwner;
import com.example.kejani_backend.utilitiesManagement.enums.BillPriority;
import com.example.kejani_backend.utilitiesManagement.enums.BillStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bills_data")
public class HouseUtility {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long billId;
    private String billName;
    private String billLogo;
    private LocalDate paymentDate;
    private int billBalance;
    private int billAmount;
    private BillStatus billStatus;
    private BillPriority billPriority;

    @ManyToOne
    @JoinColumn(name = "userIdentity", nullable = false)
    private HouseOwner houseOwner;

}
