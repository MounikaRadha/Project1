package com.m0wn1la.app2.request;

import lombok.Data;

@Data
public class PostDataRequest {
    private String endpoint;
    private Long userId;
    private String postData;
    private String tags;
}
