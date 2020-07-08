package grp.wudi.j2ee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import grp.wudi.j2ee.dao.AdminDao;
import grp.wudi.j2ee.entity.Admin;
import grp.wudi.j2ee.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
    private AdminDao adminDao;
	
	@Override
	public boolean checkAdmin(Admin admin) {
		String passwd1 = admin.getAdminPassword();
		String passwd2;
		if(null != adminDao.checkPassword(admin.getAdminAccount())) {
			passwd2 = adminDao.checkPassword(admin.getAdminAccount()).getAdminPassword();
		}else {
			return false;
		}
		boolean isRight = passwd1.equals(passwd2);
		return isRight;
	}

	@Override
	public int addAdmin(Admin admin) {
		if(null == adminDao.findByAccount(admin.getAdminAccount())) {
			return adminDao.addAdmin(admin);
		}
		return -1;
	}

	@Override
	public int deleteAdmin(int id) {
		return adminDao.removeAdmin(id);
	}

	@Override
	public Admin getAdminById(int id) {
		return adminDao.findById(id);
	}

	@Override
	public int update(Admin admin) {
		return adminDao.update(admin);
	}

	@Override
	public List<Admin> findAll() {
		return adminDao.findAll();
	}

	@Override
	public PageInfo<Admin> finAll(int p) {
		PageHelper.startPage(p, 5);
		List<Admin> admins = adminDao.findAll();
		return new PageInfo<Admin>(admins, 5);
	}

	@Override
	public Admin getAdminByAccount(String account) {
		return adminDao.findByAccount(account);
	}

	@Override
	public int findAdminId(String account) {
		return adminDao.findAdminId(account);
	}

	@Override
	public int findAdminType(String account) {
		return adminDao.findAdminType(account);
	}

}
