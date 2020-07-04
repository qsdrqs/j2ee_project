package grp.wudi.j2ee.service;

import grp.wudi.j2ee.entity.Agent;
import grp.wudi.j2ee.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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
    public void testGetUserById() {
        System.out.println(agentService.findById(1));
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

}
