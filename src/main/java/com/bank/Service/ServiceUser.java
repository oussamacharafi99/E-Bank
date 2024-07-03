package com.bank.Service;
import com.bank.Repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceUser {
    @Autowired
    RepositoryUser repoUser;
}
