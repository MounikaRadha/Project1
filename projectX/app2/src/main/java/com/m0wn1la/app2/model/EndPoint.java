package com.m0wn1la.app2.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "end_points")
public class EndPoint extends BaseEntity {
    @Column(name = "endpoint")
    public String endPoint;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owned_by", referencedColumnName = "id")
    public User ownedBy;
    @OneToMany(mappedBy = "endPoint")
    public List<PostedData> postedData;
}
