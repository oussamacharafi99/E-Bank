package com.bank.Controller;

import com.bank.Model.Transaction;
import com.bank.Service.ServiceTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    ServiceTransaction serviceTransaction;

    @PostMapping("add")
    public String addTransaction(@RequestBody Transaction transaction) {
        return serviceTransaction.CreateTransaction(transaction);
    }
}
