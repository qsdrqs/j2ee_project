package grp.wudi.j2ee.entity;

public class Admin {
	private String adminAccount;
	private String adminPassword;
	public String getAdminAccount() {
		return adminAccount;
	}
	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	@Override
	public String toString() {
		return "Admin [adminAccount=" + adminAccount + ", adminPassword=" + adminPassword + "]";
	}
	
	
}
