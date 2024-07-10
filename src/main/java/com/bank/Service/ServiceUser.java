package com.bank.Service;
import com.bank.DTO.SignupRequest;
import com.bank.Model.User;
import com.bank.Repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceUser {
    @Autowired
    RepositoryUser repoUser;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User getUser(Integer id) {
        return repoUser.findUserById(id);
    }
    @Transactional
    public void addUser(SignupRequest signupRequest) {
        String username =signupRequest.username();
        String hashedPassword =passwordEncoder.encode(signupRequest.password());
        String cin = signupRequest.cin();
        Integer age = signupRequest.age();
        String genre = signupRequest.genre();
        User user =new User();
        user.setUsername(username);
        user.setPassword(hashedPassword);
        user.setCin(cin);
        user.setAge(age);
        user.setGenre(genre);
        repoUser.save(user);
    }

    public void updateUser(Integer id , User user) {
        repoUser.save(user);
    }

    public void deleteUser(Integer id) {
        repoUser.deleteById(id);
    }
}
