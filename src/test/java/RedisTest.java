
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tshop.redis.RedisClientTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class RedisTest {
	@Autowired
	private RedisClientTemplate redisClientTemplate;

	@Test
	public void testSayHello() {

		String key = "hello";
		String value = "value ";
		Object return1 = redisClientTemplate.set(key, value,1);
		try {
			Thread.sleep(1000*5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Object return2 = redisClientTemplate.get("hello");
	System.out.println(return2);
	}
}