package com.example.kejani_backend.Usermanagement.entities;

import com.example.kejani_backend.UtilitiesManagement.enums.BillPriority;
import com.example.kejani_backend.UtilitiesManagement.models.HouseUtility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UserData")
public class HouseOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userIdentity")
    private Long userId;
    @Column(name = "user")
    private String userName;
    @Column(name = "userEmail", unique = true, length = 200)
    private String email;
    @Column(name = "userPhone", unique = true, length = 100)
    private String mobileNumber;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "houseOwner")
    private Set<HouseUtility> houseUtility;



}
