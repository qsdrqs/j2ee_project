package grp.wudi.j2ee.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import grp.wudi.j2ee.entity.User;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void testAdd() {
		User user = new User();
		user.setUserName("赵100");
		user.setUserSex(1);
		user.setUserAccount("一二三四");
		user.setUserPasswordsha256("123456");
		user.setUserMail("123456@qq.com");
		user.setUserTelephone("123456");
		userService.add(user);
	}

	@Test
	public void testGetUserById() {
		System.out.println(userService.getUserById(10));
	}

	@Test
	public void testUpdate() {
		User user = new User();
		user.setUserId(1);
		user.setUserName("王五");
		user.setUserSex(1);
		user.setUserAccount("沙坡小白龙");
		user.setUserPasswordsha256("234567");
		user.setUserMail("123456@qq.com");
		user.setUserTelephone("123456");
		userService.update(user);
	}

	@Test
	public void testGetUserByKeyword() {

		System.out.println(userService.getUserByKeyword("赵四", 1));

	}

	@Test
	public void testFindAll() {
		List<User> list = userService.findAll();
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testDeleteUser() {
		userService.deleteUser(2);
	}

	@Test
	public void testVerifyUser() {
		User user = userService.verifyUser("一二三四", "123456");

		System.out.println(user);

	}
}