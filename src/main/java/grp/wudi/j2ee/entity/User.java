package grp.wudi.j2ee.entity;

public class User {
	private int userId;//用户ID
	private String userName;//用户姓名
	private int userSex;//用户性别，1为男性，0为女性
	private String userAccount;//用户名称
	private String userPassword; //用户密码
	private String userMail;//用户邮箱
	private String userTelephone; //用户电话
	
	
	public User() {
		
	}
	public User(String userName, int userSex, String userAccount) {
		this.userName = userName;
		this.userSex = userSex;
		this.userAccount = userAccount;
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
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userSex=" + userSex + ", userAccount="
				+ userAccount + ", userPassword=" + userPassword + ", userMail=" + userMail + ", userTelephone="
				+ userTelephone + "]";
	}
}
