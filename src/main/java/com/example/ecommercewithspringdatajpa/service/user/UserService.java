package com.example.ecommercewithspringdatajpa.service.user;

import com.example.ecommercewithspringdatajpa.entity.User;
import com.example.ecommercewithspringdatajpa.exception.UserNotFoundException;
import com.example.ecommercewithspringdatajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    private final UserRepository userRepo;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepo,
                       UserRepository userRepository){
        this.userRepo = userRepo;
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getByID(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(email));
    }

    @Override
    public String getUserNameByID(Integer id) {
        return userRepository.findUserNameByID(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}
