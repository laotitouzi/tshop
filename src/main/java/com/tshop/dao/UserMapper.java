package com.tshop.dao;

import com.tshop.entity.User;
import com.tshop.page.Criteria;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Han, Tixiag
 *
 */

@Service("userMapper")
public interface UserMapper {

	User getUserByUsername(String username);

	User getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

	int insertUser(User User);

	int updateUser(User User);

	User getUserById(@Param("userId") String userId);

	int delete(int id);

	List<User> getUser(Criteria criteria );
}
