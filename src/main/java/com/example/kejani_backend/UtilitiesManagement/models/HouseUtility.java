package com.example.kejani_backend.UtilitiesManagement.models;

import com.example.kejani_backend.Usermanagement.entities.HouseOwner;
import com.example.kejani_backend.UtilitiesManagement.enums.BillPriority;
import com.example.kejani_backend.UtilitiesManagement.enums.BillStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


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
