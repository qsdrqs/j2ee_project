package grp.wudi.j2ee.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import grp.wudi.j2ee.dao.AgentDao;
import grp.wudi.j2ee.entity.Agent;
import grp.wudi.j2ee.service.AgentService;
import grp.wudi.j2ee.utils.SHA256Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class AgentServiceImpl implements AgentService {
    @Autowired
    private AgentDao dao;
    @Override
    public List<Agent> findAll() {
        System.out.println("业务层执行了...");
        return dao.findAll();
    }

    @Override
    public Agent findById(int id) {
        return dao.findById(id);
    }

    @Override
    public int addAgent(Agent agent) {
        System.out.println("业务层执行了...");
        agent.setAgentPassword(SHA256Util.stringToSHA256(agent.getAgentPassword()));
        return dao.addAgent(agent);
    }

    @Override
    public int deleteAgent(int id) {
        System.out.println("业务层执行了...");
        return dao.deleteAgent(id);

    }
    @Override
    public PageInfo<Agent> finAll(int p) {
        PageHelper.startPage(p, 5);
        List<Agent> agents = dao.findAll();
        return new PageInfo<Agent>(agents,5);
    }
    @Override
    public int updateAgent(Agent agent){
        System.out.println("业务层执行了更新经纪人信息...");
        if(agent.getAgentSexStr()!=null){
            if(agent.getAgentSexStr().equals("男")){
                agent.setAgentSex(1);
            }else{
                agent.setAgentSex(0);
            }
        }
        agent.setAgentPassword(SHA256Util.stringToSHA256(agent.getAgentPassword()));
        return dao.addAgent(agent);
    }
}
