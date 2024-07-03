package com.bank.Service;
import com.bank.Repository.RepositoryTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTransaction {
    @Autowired
    RepositoryTransaction transaction;
}
