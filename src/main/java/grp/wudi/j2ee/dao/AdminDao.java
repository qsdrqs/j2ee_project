package grp.wudi.j2ee.dao;

import java.util.List;

import grp.wudi.j2ee.entity.Admin;

public interface AdminDao {
	Admin checkPassword(String adminAccount);
	
	public int removeAdmin(int id);
	
	public int addAdmin(Admin admin);
	
	public Admin findById(int id);
	
	public List<Admin> findAll();
	
	public int update(Admin admin);
	
	public Admin findByAccount(String account);
	
	public int findAdminId(String account);
	
	public int findAdminType(String account);
}
