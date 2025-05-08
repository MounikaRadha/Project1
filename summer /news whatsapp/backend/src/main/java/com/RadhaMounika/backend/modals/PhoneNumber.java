package com.RadhaMounika.backend.modals;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="phone_numbers")
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_phone_number")
    private String userPhoneNumber;


}
