package com.example.kejani_backend.UtilitiesManagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


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
    private boolean billStatus;
}
