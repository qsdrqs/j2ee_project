package grp.wudi.j2ee.service.impl;

import grp.wudi.j2ee.dao.HouseAgentDao;
import grp.wudi.j2ee.dao.HouseDao;
import grp.wudi.j2ee.entity.Agent;
import grp.wudi.j2ee.entity.House;
import grp.wudi.j2ee.service.HouseAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseAgentServiceImpl implements HouseAgentService {
    @Autowired
    private HouseAgentDao houseAgentDao;
    @Autowired
    private  HouseDao houseDao;


    @Override
    public List<House> findAll() {
        return houseAgentDao.findAll();
    }

    @Override
    public List<House> getHouseByAgentId(int agentID) {
        return houseAgentDao.findHouseByAgentId(agentID);
    }

    @Override
    public void addRelation(House houseAgent) {
        House house = houseDao.findById(houseAgent.getHouseId());
        house.setAgentId(houseAgent.getAgentId());
        houseAgentDao.addRelation(houseAgent);
    }

    @Override
    public void updateRelation(House houseAgent) {
        houseDao.updateHouse(houseAgent);
        houseAgentDao.updateRelation(houseAgent);
    }

    @Override
    public void deleteRelation(int houseId) {
        houseAgentDao.deleteRelation(houseId);

    }
    @Override
    public Agent findAgentByHouseId(int houseId){
        Agent agent = houseAgentDao.findAgentByHouseId(houseId);
        return agent;
    }
}
