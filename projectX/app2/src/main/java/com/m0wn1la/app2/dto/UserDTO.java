package com.m0wn1la.app2.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private List<EndPointDTOWithUserDTO> endPointDTOWithUserDTOS;
}
