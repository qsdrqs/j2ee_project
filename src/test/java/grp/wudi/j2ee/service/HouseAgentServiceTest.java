package grp.wudi.j2ee.service;

import grp.wudi.j2ee.entity.Agent;
import grp.wudi.j2ee.entity.House;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class HouseAgentServiceTest {
    @Autowired
    private HouseAgentService houseAgentService;

    @Test
    public void findAllTest() {
        List<House> list = houseAgentService.findAll();
        for (House houseAgent:list) {
            System.out.println(houseAgent);
        }
    }



    @Test
    public void findHouseByAgentIdTest(){

        List<House> list = houseAgentService.getHouseByAgentId(43);
        for (House houseAgent:list) {
            if (null != houseAgent.getCreateTime()) {
                SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                String createTimeStr = date.format(houseAgent.getCreateTime());
                houseAgent.setCreateTimeStr(createTimeStr);

            }

            System.out.println(houseAgent);
        }
    }





    @Test
    public void addRelationTest() {
        House houseAgent = new House();
        houseAgent.setAgentId(44);
        houseAgent.setHouseId(2);


        houseAgentService.addRelation(houseAgent);

    }



    @Test
    public void updateRelationTest(){
        House houseAgent = new House();
        houseAgent.setAgentId(43);
        houseAgent.setHouseId(9);


        houseAgentService.updateRelation(houseAgent);

    }



    @Test
    public void deleteHouseTest(){
        houseAgentService.deleteRelation(3);
    }
    @Test
    public void testFindAgentByHouseId(){
        Agent agent = houseAgentService.findAgentByHouseId(1);
        System.out.println(agent);
    }

}
