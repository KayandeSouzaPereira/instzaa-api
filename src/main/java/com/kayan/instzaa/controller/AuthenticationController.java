package com.kayan.instzaa.controller;


import com.kayan.instzaa.configuration.JwtService;
import com.kayan.instzaa.controller.dto.LoginResponseDTO;
import com.kayan.instzaa.controller.dto.LoginUserDto;
import com.kayan.instzaa.controller.dto.RegisterUserDto;
import com.kayan.instzaa.domain.model.UserInfo;
import com.kayan.instzaa.service.AuthenticationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/auth")
@RestController
@CrossOrigin
@Tag(name = "Controlador de autenticação", description = "RESTful API for delivery.")
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<RegisterUserDto> register(@RequestBody RegisterUserDto registerUserDto) {
        UserInfo registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registerUserDto);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> authenticate(@RequestBody LoginUserDto loginUserDto) {
        UserInfo authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponseDTO loginResponse = new LoginResponseDTO();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        System.out.println(loginResponse);

        return ResponseEntity.ok(loginResponse);
    }
}
