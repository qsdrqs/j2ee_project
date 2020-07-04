package grp.wudi.j2ee.dao;

import java.util.List;

import grp.wudi.j2ee.entity.User;


public interface UserDao {

	public User findById(int id);
	public List<User> findByKeyword(User user);
	public int addUser(User user);
	public int update(User user);
	public List<User> findAll();
	public int removeUser(int id);
}
