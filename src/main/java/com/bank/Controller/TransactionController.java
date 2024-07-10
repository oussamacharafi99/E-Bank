package com.bank.Controller;

import com.bank.Model.Transaction;
import com.bank.Service.ServiceTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    ServiceTransaction serviceTransaction;

    @PostMapping("add/{id}")
    public String addTransaction(@PathVariable Integer id , @RequestBody Transaction transaction) {
        return serviceTransaction.CreateTransaction(id , transaction);
    }

    @GetMapping("/get/{id}")
    public List<Transaction> findTransaction(@PathVariable("id") Integer id) {
        return serviceTransaction.GetTransactionByAccount(id);
    }
}
