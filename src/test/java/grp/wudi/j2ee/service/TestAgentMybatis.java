package grp.wudi.j2ee.service;

import grp.wudi.j2ee.entity.Agent;
import grp.wudi.j2ee.utils.SHA256Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.security.Provider;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestAgentMybatis {
    @Autowired
    private AgentService agentService;

    @Test
    public void testFindAll(){
        List<Agent> list = agentService.findAll();
        for (Agent agent:list) {
            System.out.println(agent);
        }
    }
    @Test
    public void testAdd() {
//        User user = new User();
//        user.setUserName("赵四");
//        user.setUserSex(1);
//        user.setUserAccount("交大蔡徐坤");
//        user.setUserPasswordsha256("123456");
//        user.setUserMail("123456@qq.com");
//        user.setUserTelephone("123456");
        Agent agent = new Agent();
        agent.setAgentName("马六");
        agent.setAgentSex(1);
        agent.setAgentEmail("232323@123.com");
        agent.setAgentAccount("machao1234");
        agent.setAgentPassword("123456");
        agent.setAgentProfile("无可替代,专业!");
        agent.setAgentTel("123456789098");
        agentService.addAgent(agent);
    }

    @Test
    public void testGetUserById() {
       Agent agent = agentService.findById(75);
        System.out.println(agent);
    }


    @Test
    public void testDeleteUser() {
        agentService.deleteAgent(1);
    }

    @Test
    public void testUpdateAgent(){
        Agent agent = new Agent();
        agent.setAgentId(60);
        agent.setAgentName("小春");
        agent.setAgentSex(1);
        agent.setAgentEmail("test");
        agent.setAgentAccount("abc");
        agent.setAgentTel("a1234");
        agent.setAgentPassword("123456");
        agentService.updateAgent(agent);

    }

    @Test
    public void run1() {
        Agent agent = agentService.findById(69);
        String str1 = agent.getAgentPassword();
        System.out.println(str1);
        System.out.println(SHA256Util.stringToSHA256("1234567"));
        System.out.println(str1.equals(SHA256Util.stringToSHA256("1234567")));
    }

    @Test
    public void run2() {
        Agent agent = agentService.verifyAgent("test", "123456");

        System.out.println(agent);

    }
}
