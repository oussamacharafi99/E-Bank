package com.bank.Service;
import com.bank.Model.User;
import com.bank.Repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceUser {
    @Autowired
    RepositoryUser repoUser;

    public User getUser(Integer id) {
        return repoUser.findUserById(id);
    }
}
