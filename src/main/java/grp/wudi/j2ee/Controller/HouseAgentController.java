package grp.wudi.j2ee.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import grp.wudi.j2ee.entity.House;
import grp.wudi.j2ee.service.impl.HouseAgentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/houseAgent")
public class HouseAgentController {
    @Autowired
    private HouseAgentServiceImpl houseAgentService;

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
                JSONObject jsonObject = JSON

                String result = JSON.toJSONString(list);
                System.out.println(list);
                return result;
            }
        }
        return null;
    }
}
