package grp.wudi.j2ee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
