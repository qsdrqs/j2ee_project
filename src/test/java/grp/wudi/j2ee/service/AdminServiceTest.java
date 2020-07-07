package grp.wudi.j2ee.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import grp.wudi.j2ee.entity.Admin;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class AdminServiceTest {

	@Autowired
	private AdminService adminService;
	
	@Test
	public void testCheckAdmin() {
		Admin admin = new Admin();
		admin.setAdminAccount("admin6");
		admin.setAdminPassword("123456");
		System.out.println(adminService.checkAdmin(admin));
	}
}
