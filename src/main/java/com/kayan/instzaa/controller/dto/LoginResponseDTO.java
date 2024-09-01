package com.kayan.instzaa.controller.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginResponseDTO {
    private String token;
    private String cargo;
    private long expiresIn;
}
