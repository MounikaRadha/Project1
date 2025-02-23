package com.m0wn1la.app2.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "posted_by")
public class PostedData extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "end_points", referencedColumnName = "id")
    public EndPoint endPoint;
    @ManyToOne
    @JoinColumn(name="posted_by", referencedColumnName = "id")
    public User postedBy;
    @Column(name = "post_data")
    public String postData;
    @Column(name = "tags" )
    public String tags;
}
