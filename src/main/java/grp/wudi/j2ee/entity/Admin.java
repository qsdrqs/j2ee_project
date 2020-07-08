package grp.wudi.j2ee.entity;

public class Admin {
	private int adminId;
	private String adminAccount;
	private String adminPassword;
	private int type; //1为超级管理员，0为普通管理员
	private String typeStr;
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
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTypeStr() {
		 switch (type){
        case 0:
            return "普通管理员";
        case 1:
            return "超级管理员";
    }
    return "错误";
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminAccount=" + adminAccount + ", adminPassword=" + adminPassword
				+ ", type=" + type + "]";
	}
	
}
