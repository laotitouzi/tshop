package com.tshop.service;

import com.tshop.entity.User;
import com.tshop.dao.UserMapper;
import com.tshop.exception.BusinessException;
import com.tshop.entity.Page;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LaoT
 */
@Service("userService")
public class UserService {
    private final static Logger log= Logger.getLogger(UserService.class);
    @Autowired
    private UserMapper UserMapper;

    public User getUser(String username) {
        return UserMapper.getUserByUsername(username);
    }

    public User getUser(String username, String password) {
        return UserMapper.getUserByUsernameAndPassword(username, password);
    }

    public void addUser(User user) {
        try{
        UserMapper.insertUser(user);
            System.out.println(user.getUserId());
        }catch (Exception e){
            log.error(e.getCause().getMessage());
            throw  new BusinessException(e);
        }

    }

    public void updateUser(User User) {
        UserMapper.updateUser(User);
    }
    public User getUserById(String userId) {
        return  UserMapper.getUserById(userId);
    }

    public  int delete(int id){
        return  UserMapper.delete(id);
    }

    public Page queryForPage(){
        Page<User> page = new Page<User>();
        page.setPageSize(2);
        List<User> users = UserMapper.getUser(page);
        page.setList(users);
        return page;
    }

}
