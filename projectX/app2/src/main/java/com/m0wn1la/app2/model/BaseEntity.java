package com.m0wn1la.app2.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
}
