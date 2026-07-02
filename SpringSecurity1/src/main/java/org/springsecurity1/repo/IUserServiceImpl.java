package org.springsecurity1.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springsecurity1.model.User;

import java.util.List;

@Service
public class IUserServiceImpl implements IUserService{

    @Autowired
    private IUserRepo repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registeruser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }

    @Override
    public List<User> getAllusers() {
        return repo.findAll();
    }
}
