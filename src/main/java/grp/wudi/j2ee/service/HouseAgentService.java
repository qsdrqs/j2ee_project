package grp.wudi.j2ee.service;

import grp.wudi.j2ee.entity.Agent;
import grp.wudi.j2ee.entity.House;

import java.util.List;


public interface HouseAgentService {

    public List<House> findAll();

    public List<House> getHouseByAgentId(int agentID);

    public void addRelation(House houseAgent);

    public void updateRelation(House houseAgent);

    public void deleteRelation(int houseId);
    public Agent findAgentByHouseId(int houseId);
}
