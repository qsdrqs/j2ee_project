package grp.wudi.j2ee.entity;

import java.util.Date;

import grp.wudi.j2ee.utils.DateFormat;

public class User {
	private int userId;// 用户ID
	private String userName;// 用户姓名
	private int userSex;// 用户性别，1为男性，0为女性
	private String userAccount;// 用户名称
	private String userPasswordsha256; // 用户密码
	private String userMail;// 用户邮箱
	private String userTelephone; // 用户电话
	private Date userCreatetime;// 用户注册时间
	private Date userUpdatetime;// 用户最后一次修改时间

	public User() {
		Date date = new Date();
		setUserCreatetime(date);
		setUserUpdatetime(date);
	}

	public User(String userName, int userSex, String userAccount, String userPassword, String userMail,
			String userTelephone) {
		this.userName = userName;
		this.userSex = userSex;
		this.userAccount = userAccount;
		this.userPasswordsha256 = userPassword;
		this.userMail = userMail;
		this.userTelephone = userTelephone;
		Date date = new Date();
		setUserCreatetime(date);
		setUserUpdatetime(date);
	}

	public User(String userName, int userSex, String userAccount, String userPasswordsha256, String userTelephone) {
		this.userName = userName;
		this.userSex = userSex;
		this.userAccount = userAccount;
		this.userPasswordsha256 = userPasswordsha256;
		this.userTelephone = userTelephone;
		Date date = new Date();
		setUserCreatetime(date);
		setUserUpdatetime(date);
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

	public String getUserPasswordsha256() {
		return userPasswordsha256;
	}

	public void setUserPasswordsha256(String userPassword) {
		this.userPasswordsha256 = userPassword;
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

	public Date getUserCreatetime() {
		return userCreatetime;
	}

	public void setUserCreatetime(Date userCreatetime) {
		this.userCreatetime = userCreatetime;
	}

	public Date getUserUpdatetime() {
		return userUpdatetime;
	}

	public void setUserUpdatetime(Date userUpdatetime) {
		this.userUpdatetime = userUpdatetime;
	}

	public String getUserCreatetimeStr() {
		if (null != this.userCreatetime) {
			return DateFormat.dataFormatToStr(userCreatetime);
		}
		return null;
	}

	public void setUserCreatetimeStr(String userCreatetimeStr) {
	}

	public String getUserUpdatetimeStr() {
		if (null != this.userUpdatetime) {
			return DateFormat.dataFormatToStr(userUpdatetime);
		}
		return null;
	}

	public void setUserUpdatetimeStr(String userUpdatetimeStr) {
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userSex=" + userSex + ", userAccount="
				+ userAccount + ", userPassword=" + userPasswordsha256 + ", userMail=" + userMail + ", userTelephone="
				+ userTelephone + ", userCreatetime=" + userCreatetime + ", userUpdatetime=" + userUpdatetime + "]";
	}

}
