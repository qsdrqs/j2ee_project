package grp.wudi.j2ee.dao;

import java.util.List;

import grp.wudi.j2ee.entity.User;
import org.apache.ibatis.annotations.Select;


public interface UserDao {
//	@Select("SELECT user_id," +
//			"user_name," +
//			"user_sex," +
//			"user_account" +
//			"FROM " +
//			"user " +
//			"WHERE user_id = #{id} ")
	public User findById(int id);
	public List<User> findByAccount(String account);
	public int addUser(User user);
	public int update(User user);
	public List<User> findAll();
}
