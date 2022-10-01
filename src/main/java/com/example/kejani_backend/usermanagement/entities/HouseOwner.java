package com.example.kejani_backend.usermanagement.entities;

import com.example.kejani_backend.cardmanagement.entities.Cards;
import com.example.kejani_backend.utilitiesManagement.models.HouseBill;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "houseOwner", cascade = CascadeType.ALL)
    @Fetch(value= FetchMode.SELECT)
    @JsonManagedReference
    private List<HouseBill> houseBill;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "houseOwner")
    private List<Cards> userCards;



}
