package com.example.demo.modals;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Entity(name = "user_data")
public class UserData {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "business_type")
    public String businessType;
    @Column(name = "target_audience")
    public String targetAudience;
    @Column(name = "key_selling_points")
    public String keySellingPoints;
}
