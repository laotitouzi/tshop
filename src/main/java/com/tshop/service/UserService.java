package com.tshop.service;

import com.tshop.entity.User;
import com.tshop.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author LaoT
 */
@Service
public class UserService {

    @Autowired
    private UserMapper UserMapper;

    public User getUser(String username) {
        return UserMapper.getUserByUsername(username);
    }

    public User getUser(String username, String password) {
        return UserMapper.getUserByUsernameAndPassword(username, password);
    }

    @Transactional
    public void insertUser(User User) {
        UserMapper.insertUser(User);
    }

    @Transactional
    public void updateUser(User User) {
        UserMapper.updateUser(User);
    }

}
