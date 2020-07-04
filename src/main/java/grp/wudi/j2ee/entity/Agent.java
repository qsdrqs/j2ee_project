package grp.wudi.j2ee.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Agent implements Serializable {
    private Integer agentId;    //房产经纪人的唯一标识ID
    private String agentName;   //房产经纪人的姓名
    private Integer agentSex;   //房产经纪人的性别
    private String agentTel;    //经纪人的联系电话
    private String agentEmail;  //经纪人的电子邮件
    private Date agentRegistertime;  //经纪人的注册时间

    private String registerTimeStr;

    private Date agentLeavetime;     //经纪人的离职时间

    private String leaveTimeStr;
    private String agentProfile;    //经纪人的个人介绍
    private String agentAccount;    //经纪人的账户名
    private String agentPassword; //经纪人的账户密码

    public Agent(){
        this.agentRegistertime = new Date();
        //初始化离职时间为2099-12-30
        this.agentLeavetime = new Date(2099,12,30);
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Integer getAgentSex() {
        return agentSex;
    }

    public void setAgentSex(Integer agentSex) {
        this.agentSex = agentSex;
    }

    public String getAgentTel() {
        return agentTel;
    }

    public void setAgentTel(String agentTel) {
        this.agentTel = agentTel;
    }

    public String getAgentEmail() {
        return agentEmail;
    }

    public void setAgentEmail(String agentEmail) {
        this.agentEmail = agentEmail;
    }

    public Date getAgentRegistertime() {
        return agentRegistertime;
    }

    public void setAgentRegistertime(Date agentRegistertime) {
        this.agentRegistertime = agentRegistertime;
    }

    public String getRegisterTimeStr() {
        if(agentRegistertime !=null){
            SimpleDateFormat date =  new SimpleDateFormat("yyyy-MM-dd");
            registerTimeStr = date.format(this.agentRegistertime);
            return registerTimeStr;
        }
        return null;
    }

    public void setRegisterTimeStr(String registerTimeStr) {
        this.registerTimeStr = registerTimeStr;
    }

    public Date getAgentLeavetime() {
        return agentLeavetime;
    }

    public void setAgentLeavetime(Date agentLeavetime) {
        this.agentLeavetime = agentLeavetime;
    }

    public String getLeaveTimeStr() {
        if(agentLeavetime !=null){
            SimpleDateFormat date =  new SimpleDateFormat("yyyy-MM-dd");
            leaveTimeStr = date.format(this.agentLeavetime);
            return leaveTimeStr;
        }
        return null;
    }

    public void setLeaveTimeStr(String leaveTimeStr) {
        this.leaveTimeStr = leaveTimeStr;
    }

    public String getAgentProfile() {
        return agentProfile;
    }

    public void setAgentProfile(String agentProfile) {
        this.agentProfile = agentProfile;
    }

    public String getAgentAccount() {
        return agentAccount;
    }

    public void setAgentAccount(String agentAccount) {
        this.agentAccount = agentAccount;
    }

    public String getAgentPassword() {
        return agentPassword;
    }

    public void setAgentPassword(String agentPassword) {
        this.agentPassword = agentPassword;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "agentId=" + agentId +
                ", agentName='" + agentName + '\'' +
                ", agentSex=" + agentSex +
                ", agentTel='" + agentTel + '\'' +
                ", agentEmail='" + agentEmail + '\'' +
                ", registerTime=" + agentRegistertime +
                ", leaveTime=" + agentLeavetime +
                ", agentProfile='" + agentProfile + '\'' +
                ", agentAccount='" + agentAccount + '\'' +
                ", agentPassword='" + agentPassword + '\'' +
                '}';
    }
}
