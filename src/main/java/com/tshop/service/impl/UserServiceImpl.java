package com.tshop.service.impl;

import com.tshop.cache.CacheKey;
import com.tshop.cache.LoadFromCache;
import com.tshop.dao.UserMapper;
import com.tshop.entity.User;
import com.tshop.exception.BusinessException;
import com.tshop.page.Criteria;
import com.tshop.page.Page;
import com.tshop.page.PageHelper;
import com.tshop.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Han, Tixiang
 * @Create 2016/6/26
 */

@Service("userService")

public class UserServiceImpl implements UserService{
    private final static Logger log = Logger.getLogger(UserService.class);
    @Autowired
    private UserMapper userMapper;

    public User getUser(String username) {
        return userMapper.getUserByUsername(username);
    }

    public User getUser(String username, String password) {
        return userMapper.getUserByUsernameAndPassword(username, password);
    }

    public void addUser(User user) {
        try {
            userMapper.insertUser(user);
            System.out.println(user.getUserId());
        } catch (Exception e) {
            log.error(e.getCause().getMessage());
            throw new BusinessException(e);
        }

    }




    public void updateUser(User User) {
        userMapper.updateUser(User);
    }

    @LoadFromCache(expire = 600)
    public User getUserById(@CacheKey  Object id) {
        return userMapper.getUserById(id);
    }

    public int delete(Object id) {
        return userMapper.delete(id);
    }

    public Page queryForPage(Criteria criteria) {
        PageHelper.newPage(criteria);
        userMapper.getUser(criteria);
        return PageHelper.endPage();
    }
}