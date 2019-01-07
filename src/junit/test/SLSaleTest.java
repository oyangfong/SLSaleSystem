package junit.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slsale.service.user.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SLSaleTest {

	@Test
	public void test() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
		UserService userService=ctx.getBean("userService",UserService.class);
		try {
			System.out.println(userService.findAll().size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
