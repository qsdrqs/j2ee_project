package grp.wudi.j2ee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grp.wudi.j2ee.dao.UserDao;
import grp.wudi.j2ee.entity.User;
import grp.wudi.j2ee.service.UserService;

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
		System.out.println("业务层执行了");
		return userDao.addUser(user);
	}

	@Override
	public int update(User user) {
		return userDao.update(user);
	}

	@Override
	public List<User> getUserByAccount(String account) {
		return userDao.findByAccount(account);
	}

	@Override
	public List<User> findAll(){
		System.out.println("业务层执行了");
		return userDao.findAll();
	}


}
