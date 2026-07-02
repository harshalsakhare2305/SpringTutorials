package org.springsecurity1.repo;

import org.springsecurity1.model.User;

import java.util.List;

public interface IUserService {

    public User registeruser(User user);

    public List<User> getAllusers();
}
