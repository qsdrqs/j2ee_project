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
		admin.setAdminAccount("admin");
		admin.setAdminPassword("123456");
		System.out.println(adminService.checkAdmin(admin));
	}
	
	@Test
	public void testAddAdmin() {
		Admin admin = new Admin();
		admin.setAdminAccount("admin4");
		admin.setAdminPassword("123456");
		System.out.println(adminService.addAdmin(admin));
	}
	
	@Test
	public void testDeleteAdmin() {
		adminService.deleteAdmin(5);
	}
	
	@Test
	public void testGetAdminById() {
		System.out.println(adminService.getAdminById(4));
	}
	
	@Test
	public void testFindAll() {
		System.out.println(adminService.findAll());
	}
	
	@Test
	public void testFindAll1() {
		System.out.println(adminService.finAll(1));
	}
	
	@Test
	public void testUpdate() {
		Admin admin = new Admin();
		admin.setAdminId(4);
		admin.setAdminAccount("admin5");
		admin.setAdminPassword("123456789");
		adminService.update(admin);
	}
	
	@Test
	public void testFindAdminId() {
		System.out.println(adminService.findAdminId("admin5"));
	}
	
	@Test
	public void testFindAdminType() {
		System.out.println(adminService.findAdminType("admin"));
	}
}
