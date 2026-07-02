package org.springsecurity1.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springsecurity1.model.User;
import org.springsecurity1.model.UserPrinciple;
import org.springsecurity1.repo.IUserRepo;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private IUserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repo.findByusername(username);
        if(user==null)throw new UsernameNotFoundException("User with username : "+ username +" Not Found");

        return new UserPrinciple(user);
    }
}
