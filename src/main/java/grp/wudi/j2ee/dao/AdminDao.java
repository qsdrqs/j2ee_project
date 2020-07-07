package grp.wudi.j2ee.dao;

import grp.wudi.j2ee.entity.Admin;

public interface AdminDao {
	Admin checkPassword(String adminAccount);
}
