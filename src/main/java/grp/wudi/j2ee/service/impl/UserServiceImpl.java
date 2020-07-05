package grp.wudi.j2ee.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import grp.wudi.j2ee.dao.UserDao;
import grp.wudi.j2ee.entity.User;
import grp.wudi.j2ee.service.UserService;
import grp.wudi.j2ee.utils.SHA256Util;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User getUserById(int id) {
		return userDao.findById(id);
	}

	@Override
	public int add(User user) {
		user.setUserPasswordsha256(SHA256Util.stringToSHA256(user.getUserPasswordsha256()));
		return userDao.addUser(user);
	}

	@Override
	public int update(User user) {
		Date date = new Date();
		user.setUserUpdatetime(date);
		user.setUserPasswordsha256(SHA256Util.stringToSHA256(user.getUserPasswordsha256()));
		return userDao.update(user);
	}

	@Override
	public List<User> getUserByKeyword(User user) {
		return userDao.findByKeyword(user);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public int deleteUser(int id) {
		return userDao.removeUser(id);
	}

	@Override
	public PageInfo<User> finAll(int p) {
		PageHelper.startPage(p, 5);
		List<User> users = userDao.findAll();
		return new PageInfo<User>(users,5);
	}

}
