package grp.wudi.j2ee.dao;
import grp.wudi.j2ee.entity.Agent;
import java.util.List;

public interface AgentDao {
    //查询所有经纪人信息
    public List<Agent> findAll();
    //根据ID查询经纪人信息
    public Agent findById(int id);
    //添加经纪人信息
    public int addAgent(Agent agent);
    //修改经纪人的信息
    public int updateAgent(Agent agent);
    //删除经纪人的信息
    public int dateleAgent(int id);
}
