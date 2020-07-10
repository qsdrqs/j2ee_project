package grp.wudi.j2ee.Controller;

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONArray;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

import grp.wudi.j2ee.entity.Agent;
import grp.wudi.j2ee.entity.House;

import grp.wudi.j2ee.service.HouseAgentService;

import grp.wudi.j2ee.entity.Result;

import grp.wudi.j2ee.service.impl.AgentServiceImpl;
import grp.wudi.j2ee.service.impl.HouseAgentServiceImpl;
import grp.wudi.j2ee.service.impl.HouseServiceImpl;
import grp.wudi.j2ee.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/house")
public class HouseController {

	@Autowired
	private HouseServiceImpl houseService;
	@Autowired
	private AgentServiceImpl agentService;
	@Autowired
	private HouseAgentServiceImpl houseAgentService;

    @RequestMapping(path = "/findAllHouse.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<House> list = houseService.findAll();
        mv.addObject("",list);
        mv.setViewName("house-list");
        return mv;
    }



    /**
     * 查找所有房源信息，并分页
     * @param p
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/findAllBypagesBack.do")
    public String findAllBypages(@RequestParam(value = "p", defaultValue = "1") int p, Model model) throws Exception {
        System.out.println("表现层正在执行分页查询房源信息....");
        PageInfo<House> pi = houseService.findAll(p);
        model.addAttribute("pi", pi);
        return "house-list";
    }

    /**

     * 删除房屋信息
     */
    @RequestMapping(path = "/delete.do")
    public String delete(@RequestParam(value = "id", required = true) int id) {
        House removeHouse = houseService.getHouseById(id);
        houseService.delete(id);
        id = removeHouse.getUserId();
        return "redirect:/house/findAllBypages.do";
    }

    @RequestMapping(path = "/findAllBypages")
    @CrossOrigin(origins = "*")
    public @ResponseBody
    String findAllBypagess(int p, String address, int type,
                           int minPrice, int maxPrice,
                           int minArea, int maxArea, int hasLift) throws UnsupportedEncodingException {
        System.out.println("表现层正在执行分页查找房源信息...");
        System.out.println(address);
        address = new String(address.getBytes("ISO8859_1"),"UTF-8");
        System.out.println(address);
        System.out.println(type);
        PageInfo<House> list = houseService.findBykeywordsPages(p, address, type
                , minPrice, maxPrice, minArea, maxArea, hasLift);
        if (null != list) {
            String result = JSON.toJSONString(list);
            System.out.println(list);
            return result;
        }
        return null;
    }


    @RequestMapping(path = "/indexHouse")
    @CrossOrigin(origins = "*")
    public @ResponseBody String findAllInIndex(int p){
        System.out.println(p);
        PageInfo<House> list = houseService.findAll(p);
        System.out.println("表现层正在执行分页查找房源信息...");
        System.out.println(list);
        if (null != list) {
            String result = JSON.toJSONString(list);
            System.out.println(list);
            return result;
        }
        return null;
    }



    /**
     * 审核房屋信息
     * @param id
     * @return
     */
//    @RequestMapping(path = "/update")
//    public String update(@RequestParam(value = "id", required = true) int id, Model model) {
//        House house = houseService.getHouseById(id);
//        model.addAttribute("house", house);
//        return "house-update";
//    }
//
//    @PostMapping("/update")
//    public String update(House house) {
//        houseService.update(house);
//        return "redirect:/house/findAllBypagesBack";
//
//    }


	@RequestMapping(path = "/Preupdate.do")
	public ModelAndView PreupdateAgent(int id) {
		System.out.println("业务层正在执行修改...");
		ModelAndView mv = new ModelAndView();
		House house = houseService.getHouseById(id);
		System.out.println("从数据库得到的agent信息" + house);
		mv.addObject("house", house);
		mv.setViewName("house-update");
		return mv;
	}

	@RequestMapping(path = "/update.do")
	public String update(House house) {
		System.out.println("表现层从表单接受到的信息：" + house);
    house.setHousePicture(null);
		houseService.update(house);
		return "redirect:/house/findAllBypagesBack.do";
	}

	@RequestMapping(path = "/allowcation.do")
	public String allowcation(@RequestParam(value = "p", defaultValue = "1") int p, Model model) {
		PageInfo<House> pi = houseService.allocation(p);
		model.addAttribute("pi", pi);
		return "allocation-list";
	}

	@RequestMapping("/allow.do")
	public String houseAllow(@RequestParam(value = "id", required = true) int id,
			@RequestParam(value = "p", defaultValue = "1") int p, Model model) {
		PageInfo<Agent> pi = agentService.finAll(p);
		model.addAttribute("pi", pi);
		return "house-allow";

	}

	@PostMapping("/allow.do")
	public String allow(House house) {
		houseService.allow(house);
		return "redirect:/house/allowcation.do";

	}

	@RequestMapping(path = "/soldout")
	@CrossOrigin(origins = "*")
	public @ResponseBody String setSoldOut(int houseId) {
		System.out.println("表现层正在执行修改房屋状态:" + houseId);
		House house = houseService.getHouseById(houseId);
		house.setStatus(3);
		houseService.update(house);
		return "OK!";
	}

	@RequestMapping(path = "/getHouseById")
	@CrossOrigin(origins = "*")
	public @ResponseBody String findHouseById(int hid) {
		System.out.println("表现层正在执行查询具体房源信息...");
		System.out.println(hid);
		House house = houseService.getHouseById(hid);
		if (null != house) {
			String result = JSON.toJSONString(house);
			return result;
		}
		return null;
	}

	@RequestMapping(path = "/getHouseByUid")
	@CrossOrigin(origins = "*")
	public @ResponseBody String findHouseByUid(@RequestParam(value = "id", required = true) int id,int type) {
		System.out.println("表现层正在执行用户查询自己的房源信息...");
		if(type==1){
			System.out.println("类型是："+type);
			List<House> houses = houseService.getHouseByUserId(id);
			if (null != houses) {

				List<JSONObject> jsonList = new ArrayList<JSONObject>();
				for (House house:houses) {
					JSONObject tmp = (JSONObject)JSONObject.toJSON(house);
					int houseId = house.getHouseId();
					Agent agent = houseAgentService.findAgentByHouseId(houseId);
					if(null!=agent){
						System.out.println(agent);
						tmp.put("agentName",agent.getAgentName());
						tmp.put("tel",agent.getAgentTel());
					}else {

						tmp.put("agentName","未分配");
						tmp.put("tel","未知");
					}
					jsonList.add(tmp);
				}
				String result = JSON.toJSONString(jsonList);
				return result;
			}
		}
		if (type == 2) {
			System.out.println("类型是："+type);
			List<House> houses = houseService.getHouseByUserId(id);
			if (null != houses) {

				List<JSONObject> jsonList = new ArrayList<JSONObject>();
				for (House house:houses) {
					if (house.getStatus()==3){
						JSONObject tmp = (JSONObject)JSONObject.toJSON(house);
						int houseId = house.getHouseId();
						Agent agent = houseAgentService.findAgentByHouseId(houseId);
						if(null!=agent){
							System.out.println(agent);
							tmp.put("agentName",agent.getAgentName());
							tmp.put("tel",agent.getAgentTel());
						}else {

							tmp.put("agentName","未分配");
							tmp.put("tel","未知");
						}
						jsonList.add(tmp);
						String result = JSON.toJSONString(jsonList);
						return result;
					}
				}
			}
		}
		return null;
	}



    @RequestMapping(path = "/newHouse")
    @CrossOrigin(origins = "*")
    public @ResponseBody
    String newhouse(@RequestBody String data) {

        House house = new House();

        System.out.println(data);

        JSONObject jsonData = JSONObject.parseObject(data);

        //还未更新登录拦截器，用户id手动设置
        int userId = Integer.parseInt((String)jsonData.get("userId"));




        //此处有问题，多个图片的路径还无法读取
        //String housePicture = (String)jsonData.get("picture");
        JSONArray tmp = (JSONArray)jsonData.get("fileList");
        String housePicture = tmp.toJSONString();
        System.out.println(housePicture);




        String address = (String)jsonData.get("properties");
        int unitPrice = Integer.parseInt((String)jsonData.get("unit_price"));
        int area = Integer.parseInt((String) jsonData.get("area"));

        int floor = Integer.parseInt((String)jsonData.get("floor"));
        int totalFloor = Integer.parseInt((String)jsonData.get("total_floor"));
        String description =(String)jsonData.get("description");
        int hasLift = Integer.parseInt((String) jsonData.get("lift"));
        int type = Integer.parseInt((String) jsonData.get("is_for_sell"));
        type = type==1 ? 0 : 1;

        String houseHead = (String)jsonData.get("title");

        int houseRoomnum = Integer.parseInt((String)jsonData.get("room_num"));
        int houseLivingroomnum = Integer.parseInt((String) jsonData.get("livingroom_num"));

        String houseDecoration = (String) jsonData.get("decoration");
        String decorationdesc = (String) jsonData.get("decoration_desc");
        String sellingPoint = (String)jsonData.get("main_sellpoint");
        String surroundings = (String)jsonData.get("facility");
        String traffic = (String)jsonData.get("traffic");


        house.setUserId(userId);
        house.setHousePicture(housePicture);
        house.setAddress(address);
        house.setUnitPrice(unitPrice);
        house.setArea(area);
        house.setFloor(floor);
        house.setHouseTotalfloor(totalFloor);
        house.setDescription(description);
        house.setHasLift(hasLift);
        house.setType(type);
        house.setHouseHead(houseHead);
        house.setHouseRoomnum(houseRoomnum);
        house.setHouseLivingroomnum(houseLivingroomnum);
        house.setHouseDecoration(houseDecoration);
        house.setDecorationdesc(decorationdesc);
        house.setSellingPoint(sellingPoint);
        house.setSurroundings(surroundings);
        house.setTraffic(traffic);

        System.out.println("yes");

        houseService.addHouseFront(house);
        System.out.println("yes");


//        System.out.println("type:"+type.toString());
//        System.out.println("houseHead:"+houseHead);
//        System.out.println("description:"+description);
//        System.out.println("address:"+address);


        String json=JSON.toJSONString(new Result(true,"添加成功"));
        return json;

    }

}
