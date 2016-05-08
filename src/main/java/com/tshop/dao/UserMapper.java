package com.tshop.dao;

import com.tshop.entity.User;

/**
 * @author Han, Tixiag
 *
 */
public interface UserMapper {

	User getUserByUsername(String username);

	User getUserByUsernameAndPassword(String username, String password);

	void insertUser(User User);

	void updateUser(User User);
}
