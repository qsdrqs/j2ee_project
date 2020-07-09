package grp.wudi.j2ee.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import grp.wudi.j2ee.entity.Agent;
import grp.wudi.j2ee.entity.House;
import grp.wudi.j2ee.entity.User;
import grp.wudi.j2ee.service.impl.HouseAgentServiceImpl;
import grp.wudi.j2ee.service.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/houseAgent")
public class HouseAgentController {
    @Autowired
    private HouseAgentServiceImpl houseAgentService;
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(path = "/findHouseByAgent")
    @CrossOrigin(origins = "*")
    public @ResponseBody
    String findHouselistByAgentId(int agentId, int type) {
        System.out.println("表现层正在执行根据agentID查找房源信息.....");
        System.out.println(agentId);
        System.out.println(type);
        if (type == 1) {
            List<House> list = houseAgentService.getHouseByAgentId(agentId);
            if (null != list) {
                List<JSONObject> jsonList = new ArrayList<JSONObject>();
                //把list中的House转为JSONObject
                for (House house : list) {
                    JSONObject tmp = (JSONObject)JSONObject.toJSON(house);
                    int uId = house.getUserId();
                    User user = userService.getUserById(uId);
                    tmp.put("userName",user.getUserName());
                    tmp.put("userTelephone",user.getUserTelephone());
                    jsonList.add(tmp);
                }

                String result = JSON.toJSONString(jsonList);
                return result;
            }
        }
        if (type == 2) {
            List<House> list = houseAgentService.getHouseByAgentId(agentId);
            if (null != list) {
                List<JSONObject> jsonList = new ArrayList<JSONObject>();
                //把list中的House转为JSONObject
                for (House house : list) {
                    if (house.getStatus() != 3) {
                        continue;
                    }
                    JSONObject tmp = (JSONObject)JSONObject.toJSON(house);
                    int uId = house.getUserId();
                    User user = userService.getUserById(uId);
                    tmp.put("userName",user.getUserName());
                    tmp.put("userTelephone",user.getUserTelephone());
                    jsonList.add(tmp);
                }

                String result = JSON.toJSONString(jsonList);
                return result;
            }
        }
        return null;
    }
    
    @RequestMapping(path="/findAgentByHouseId")
    @CrossOrigin(origins = "*")
    public @ResponseBody
    String findAgentByHouseId(int houseId){
        System.out.println("表现层正在执行朝招经纪人信息...");
        Agent agent = houseAgentService.findAgentByHouseId(houseId);
        if(null!=agent){
            String result = JSON.toJSONString(agent);
            System.out.println(result);
            return result;
        }
        return null;
    }
}
