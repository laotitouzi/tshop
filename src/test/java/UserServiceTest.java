import com.tshop.service.UserService;
import com.tshop.entity.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tshop.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml") 

public class UserServiceTest {
	@Autowired 
	private UserService userService;

	@Test
	public void insert() {
		User u = new User();
		u.setUsername("zhangsan");
		u.setPassword("1");
		u.setAddress("hangzhou");
		u.setCity("杭州");
		u.setCountry("中国");
		u.setEmail("test@163.com");
		u.setNickname("tanzong");
		u.setZip("helloworkdd");
		u.setPhone("188");
		u.setState("zhejiang ");
		u.setStatus("0");
		userService.addUser(u);



		//productService.sendObject(destination, u);
	}


	@Test
	public void getUserById(){
		User u = userService.getUserById("3");
	/*	u.setUsername("我是你爷爷");

		userService.updateUser(u);*/
		System.out.println(u.getZip());
	}


	@Test
	public void getUserByNameAndPass(){
		User u = userService.getUser("zhangsan","123");
	/*	u.setUsername("我是你爷爷");

		userService.updateUser(u);*/
		System.out.println(u.getZip());
	}

	@Test
	public void delete(){
		int vvv = userService.delete(12);
		System.out.println(vvv);
	}


	@Test
	public void getUserPage(){
		Page p  = userService.queryForPage();

		System.out.println(p.getPageSize());

		System.out.println(p.getTotalPage());
	}
}



