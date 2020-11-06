package com.echo.pollingbackend.service;

import com.echo.pollingbackend.entity.User;
import com.echo.pollingbackend.exception.UsernameAlreadyExistsException;
import com.echo.pollingbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser(User user){

        try {
            //User existedUser = userRepository.findByUsername(user.getUsername());
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            //username has to be unique
            user.setUsername(user.getUsername());

            //make sure that password and confirm password match
            //we don't persist or show the confirm password
            user.setConfirmPassword(null);
            return userRepository.save(user);

        }catch (Exception exception){
            throw new UsernameAlreadyExistsException("username "+user.getUsername()+" already exists");
        }
    }

}