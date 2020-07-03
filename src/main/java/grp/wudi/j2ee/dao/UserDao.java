package grp.wudi.j2ee.dao;

import java.util.List;

import grp.wudi.j2ee.entity.User;


public interface UserDao {
	public User findById(int id);
	public List<User> findByAccount(String account);
	public int addUser(User user);
	public int update(User user);
}
