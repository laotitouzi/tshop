package com.tshop.service;

import com.tshop.dao.UserMapper;
import com.tshop.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author Han, Tixiang
 * @Create 2016/6/9
 */
@Service("roleUserService")
public class RoleUserService implements UserDetailsService {
    @Resource
    private UserMapper userMapper;
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getUserByUsername(username);
        if(user==null){
            throw  new UsernameNotFoundException("user not found");
        }
        user.setAuthorities(this.loadUserAuthorities(username));  //userMapper.loadUserAuthorities(username)
        return user;
    }

    private List<GrantedAuthority> loadUserAuthorities(String username) {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        list.add(new SimpleGrantedAuthority("ROLE_USER"));
       // list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return  list;
    }
}
