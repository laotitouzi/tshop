package com.tshop.dao;

import com.tshop.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author Han, Tixiag
 *
 */
public interface UserMapper {

	User getUserByUsername(String username);

	User getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

	void insertUser(User User);

	void updateUser(User User);

	User getUserById(@Param("userId") String userId);
}
