package com.m0wn1la.app2.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "end_points")
public class EndPoint extends BaseEntity {
    @Column(name = "end_points")
    public String endPoint;
    @ManyToOne
    @JoinColumn(name = "owned_by", referencedColumnName = "id")
    public User ownedBy;
    @OneToOne(mappedBy = "endPoint")
    public PostedData postedData;
}
