package com.kayan.instzaa.controller.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginUserDto {
    private String email;
    private String password;
}
