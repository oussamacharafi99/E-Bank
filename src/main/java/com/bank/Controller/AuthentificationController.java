package com.bank.Controller;

import com.bank.DTO.SignupRequest;
import com.bank.DTO.UserDto;
import com.bank.Service.ServiceUser;
import com.bank.config.JwtAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthentificationController {
    
    @Autowired
    ServiceUser serviceUser;
    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/signup")
    public void signUp(@RequestBody SignupRequest request) {
        serviceUser.addUser(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDto requestLogin) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestLogin.username(), requestLogin.password())
        );
        String token = JwtAuth.generateToken(requestLogin.username());
    return token;
    }
}
