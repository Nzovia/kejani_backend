package com.example.kejani_backend.usermanagement.entities;

import com.example.kejani_backend.cardmanagement.entities.Cards;
import com.example.kejani_backend.utilitiesManagement.models.HouseBill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_data")
public class HouseOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_email", unique = true, length = 200)
    private String email;
    @Column(name = "user_phone", unique = true, length = 100)
    private String mobileNumber;
    @Column(name = "user_password")
    private String password;
    @Transient
    private String confirmPassword;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "houseOwner")
    private Set<HouseBill> houseBill;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "houseOwner")
    private List<Cards> userCards;



}
