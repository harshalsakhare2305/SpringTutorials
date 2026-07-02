package org.springsecurity1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springsecurity1.model.User;

public interface IUserRepo extends JpaRepository<User,String> {

    User findByusername(String username);
}
