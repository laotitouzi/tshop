import com.tshop.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tshop.dao.UserMapper;
import com.tshop.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml") 

public class UserServiceTest {
	@Autowired 
	private UserService userService;

	@Test
	public void insert() {
		User u = new User();
		u.setUserId(1);
		u.setUsername("zhangsan");
		u.setPassword("123");
		u.setAddress("hangzhou");
		u.setCity("杭州");
		u.setCountry("中国");
		u.setEmail("test@163.com");
		u.setNickname("tanzong");
		u.setZip("helloworkdd");
		u.setPhone("188");
		u.setState("zhejiang ");
		u.setStatus("0");
		userService.insertUser(u);



		//productService.sendObject(destination, u);
	}
}
