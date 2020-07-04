package grp.wudi.j2ee.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
	private int userId;//用户ID
	private String userName;//用户姓名
	private int userSex;//用户性别，1为男性，0为女性
	private String userAccount;//用户名称
	private String userPassword; //用户密码
	private String userMail;//用户邮箱
	private String userTelephone; //用户电话
	private String userCreatetime;//用户注册时间
	private String userUpdatetime;//用户最后一次修改时间
	
	
	public User() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String dateStr=sdf.format(date);
		setUserCreatetime(dateStr);
		setUserUpdatetime(dateStr);
	}
	public User(String userName, int userSex, String userAccount) {
		this.userName = userName;
		this.userSex = userSex;
		this.userAccount = userAccount;
	}
	public User(int userId, String userName, int userSex, String userAccount, String userPassword, String userMail,
			String userTelephone) {
		this.userId = userId;
		this.userName = userName;
		this.userSex = userSex;
		this.userAccount = userAccount;
		this.userPassword = userPassword;
		this.userMail = userMail;
		this.userTelephone = userTelephone;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserSex() {
		return userSex;
	}
	public void setUserSex(int userSex) {
		this.userSex = userSex;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getUserTelephone() {
		return userTelephone;
	}
	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}
	public String getUserCreatetime() {
		return userCreatetime;
	}
	public void setUserCreatetime(String userCreatetime) {
		this.userCreatetime = userCreatetime;
	}
	public String getUserUpdatetime() {
		return userUpdatetime;
	}
	public void setUserUpdatetime(String userUpdatetime) {
		this.userUpdatetime = userUpdatetime;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userSex=" + userSex + ", userAccount="
				+ userAccount + ", userPassword=" + userPassword + ", userMail=" + userMail + ", userTelephone="
				+ userTelephone + ", userCreatetime=" + userCreatetime + ", userUpdatetime=" + userUpdatetime + "]";
	}
	
	
}
