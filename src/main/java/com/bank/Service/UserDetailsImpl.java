package com.bank.Service;

import com.bank.Model.User;
import com.bank.Repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImpl implements UserDetailsService {
    @Autowired
    RepositoryUser repositoryUser;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repositoryUser.findByUsername(username);
        System.out.println(user.getUsername()+"///:::22IMPL/"+user.getPassword());
        return user.builder().username(user.getUsername()).password(user.getPassword()).build();
    }
}
