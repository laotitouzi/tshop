package com.tshop.service;

import com.tshop.cache.CacheKey;
import com.tshop.entity.User;
import com.tshop.page.Page;
import com.tshop.page.Criteria;

/**
 * @author LaoT
 */
public interface UserService {
    public User getUser(String username);

    public User getUser(String username, String password);
    public void addUser(User user);

    public void updateUser(User User);
    public User getUserById(@CacheKey Object id);
    public int delete(Object id);

    public Page queryForPage(Criteria criteria);
}
