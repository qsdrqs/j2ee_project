package grp.wudi.j2ee.dao;

import grp.wudi.j2ee.entity.Agent;
import grp.wudi.j2ee.entity.House;

import java.util.List;

public interface HouseAgentDao {
    //查找所有房源与经纪人的对应关系
    public List<House> findAll();
    //查询指定经纪人名下的房源
    public List<House> findHouseByAgentId(int agentId);
    //增加新的房源-经纪人关对应系
    public void addRelation(House houseAgent);
    //修改指定的房源-经纪人对应关系
    public void updateRelation(House houseAgent);
    //删除指定的房源-经纪人对应关系
    public void deleteRelation(int houseId);
    //根据房源Id找经纪人
    public Agent findAgentByHouseId(int houseId);


}
