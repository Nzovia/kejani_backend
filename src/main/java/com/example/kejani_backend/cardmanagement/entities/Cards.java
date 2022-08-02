package com.example.kejani_backend.cardmanagement.entities;

import com.example.kejani_backend.usermanagement.entities.HouseOwner;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "user_cards")
public class Cards {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "card_number", unique = true)
    private Long cardNumber;

    @Column(name = "card_expiry")
    private LocalDate expiryDate;

    @Column(name = "card_cvv")
    private String cardCvv;

    @Column(name = "holder_name")
    private String cardHolderName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private HouseOwner houseOwner;
}
