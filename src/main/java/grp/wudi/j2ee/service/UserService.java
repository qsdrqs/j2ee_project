package grp.wudi.j2ee.service;

import java.util.List;

import grp.wudi.j2ee.entity.User;


public interface UserService {
	public User getUserById(int id);
	public int add(User user);
	public int update(User user);
	public List<User> getUserByAccount(String account);
}
