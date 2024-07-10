package com.bank.Controller;

import com.bank.DTO.SignupRequest;
import com.bank.Service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthentificationController {
    @Autowired
    ServiceUser serviceUser;

    @PostMapping("/signup")
    public void signUp(@RequestBody SignupRequest request) {
        serviceUser.addUser(request);
    }
}
