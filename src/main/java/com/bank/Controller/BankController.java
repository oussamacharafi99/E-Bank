package com.bank.Controller;
import com.bank.Model.User;
import com.bank.Service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BankController {

    @Autowired
    ServiceUser serviceUser;

    @GetMapping("/user")
    public User getUser() {
        return serviceUser.getUser(1);
    }
}
