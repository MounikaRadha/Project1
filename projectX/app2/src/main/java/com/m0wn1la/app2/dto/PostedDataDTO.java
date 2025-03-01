package com.m0wn1la.app2.dto;

import lombok.Data;

@Data
public class PostedDataDTO {
    private Long postId;
    private EndPointDTO endPoint;
    private LeanUserDTO postedBy;
    private String postData;
    private String tags;
}
