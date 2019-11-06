package com.pearls.apititudinaltest.controllers;

import com.pearls.apititudinaltest.common.exceptions.NotAuthorizedException;
import com.pearls.apititudinaltest.dto.AuthDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/signin")
    public void signIn(@RequestBody AuthDTO authDTO) {

        if (!"user".equals(authDTO.getUsername()) || !"pass".equals(authDTO.getPassword())) {
            throw new NotAuthorizedException();
        }
    }

}
