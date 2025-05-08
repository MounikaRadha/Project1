package com.RadhaMounika.backend.modals;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_phone_number")
    private String userPhoneNumber;


}
