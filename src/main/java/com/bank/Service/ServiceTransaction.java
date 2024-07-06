package com.bank.Service;
import com.bank.Model.Transaction;
import com.bank.Repository.RepositoryTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTransaction {
    @Autowired
    RepositoryTransaction repositoryTransaction;

    public List<Transaction> getTransaction() {
         return  repositoryTransaction.findAll();
    }

    public Transaction GetTransactionByAccount(int id) {
        return repositoryTransaction.findById(id).orElseThrow();
    }

    public Transaction CreateTransaction(Transaction transaction) {
        return repositoryTransaction.save(transaction);
    }

}
