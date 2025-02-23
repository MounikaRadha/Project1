package com.m0wn1la.app2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "users")
public class User extends BaseEntity {
    @Column(name = "name")
    public String userName;
    @OneToMany(mappedBy = "ownedBy")
    public List<EndPoint> endPoints;
    @OneToMany(mappedBy = "postedBy")
    public List<PostedData> postedData;
}
