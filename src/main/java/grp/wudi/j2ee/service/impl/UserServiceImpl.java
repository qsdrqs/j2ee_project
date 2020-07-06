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
		User user1 = userDao.findById(user.getUserId());
		if(!user1.getUserPasswordsha256().equals(SHA256Util.stringToSHA256(user.getUserPasswordsha256()))) {
			user.setUserPasswordsha256(SHA256Util.stringToSHA256(user.getUserPasswordsha256()));
		}
		return userDao.update(user);
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
		return new PageInfo<User>(users, 5);
	}

	@Override
	public PageInfo<User> getUserByKeyword(String msg,int p) {
		User user = new User();

		char[] msgChar = msg.toCharArray();  

		if (msg.matches("\\d+")) {
			int number = Integer.parseInt(msg);
			user.setUserId(number);
			user.setUserSex(number);
		}else {
			user.setUserId(0);
			user.setUserSex(-1);
		}

		user.setUserAccount(msg);
		user.setUserMail(msg);
		user.setUserTelephone(msg);

		msg ="";
		for(char i:msgChar) {
			msg = msg+i+"%";
		}
		msg = msg.substring(0,msg.length() - 1);
		user.setUserName(msg);
		user.setUserAccount(msg);
		user.setUserMail(msg);
		user.setUserTelephone(msg);
		PageHelper.startPage(p, 5);

		List<User> users = userDao.findByKeyword(user);
		return new PageInfo<User>(users, 5);
	}
}
