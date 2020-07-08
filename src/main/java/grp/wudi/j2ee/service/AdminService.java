package grp.wudi.j2ee.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import grp.wudi.j2ee.entity.Admin;

public interface AdminService {
	public boolean checkAdmin(Admin admin);
	
	public int addAdmin(Admin admin);
	
	public int deleteAdmin(int id);
	
	public Admin getAdminById(int id);
	
	public Admin getAdminByAccount(String account);
	
	public int update(Admin admin);
	
	public List<Admin> findAll();
	
	public PageInfo<Admin> finAll(int p);
	
	public int findAdminId(String account);
	
	public int findAdminType(String account);

}
