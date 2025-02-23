package com.m0wn1la.app2.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.LastModifiedBy;

@MappedSuperclass
public class BaseEntity {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "created_at")
    public Long createdAt;
}
