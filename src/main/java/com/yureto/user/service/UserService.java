package com.yureto.user.service;

import com.yureto.user.entity.User;
import com.yureto.user.exception.UserAlreadyExistsException;
import com.yureto.user.exception.UserNotFoundException;
import com.yureto.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserMapper userMapper;
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> findAll() {
        return this.userMapper.findAll();
    }

    public User findUser(int id) {
        Optional<User> user = this.userMapper.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException("user_id : " + id +  "not found");
        }
    }

    public User insert(String name, String email) {
        Optional<User> userOptional = this.userMapper.findByEmail(email);
        if (userOptional.isPresent()) {
            throw new UserAlreadyExistsException("email : " + email + " already exists");
        }

        User user = User.createUser(name, email);
        this.userMapper.insert(user);
        return user;
    }
}
