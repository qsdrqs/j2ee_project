package grp.wudi.j2ee.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import grp.wudi.j2ee.entity.User;


public interface UserService {
	public User getUserById(int id);
	public int add(User user);
	public int update(User user);
	public List<User> getUserByKeyword(User user);
	public List<User> findAll();
	PageInfo<User> finAll(int p);
	public int deleteUser(int id);
}
