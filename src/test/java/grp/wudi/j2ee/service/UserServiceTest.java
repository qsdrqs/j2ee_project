package grp.wudi.j2ee.service;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import grp.wudi.j2ee.entity.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testAdd() {
		User user = new User();
		user.setUserName("张三");
		user.setUserSex(1);
		user.setUserAccount("交大蔡徐坤");
		userService.add(user);
	}
	
	@Test
	public void testGetUserById() {
		System.out.println(userService.getUserById(1));
	}
	
	@Test
	public void testUpdate() {
		User user = new User();
		user.setUserId(1);
		user.setUserName("李四");
		user.setUserSex(1);
		user.setUserAccount("交大蔡徐坤");
		userService.update(user);
	}
	
	@Test
	public void testGetUserByAccount() {
		System.out.println(userService.getUserByAccount("交大"));
	}

}
