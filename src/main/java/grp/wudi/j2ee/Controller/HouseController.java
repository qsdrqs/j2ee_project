package grp.wudi.j2ee.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import grp.wudi.j2ee.entity.House;
import grp.wudi.j2ee.service.impl.HouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping(path="/house")
public class HouseController {
    @Autowired
    private HouseServiceImpl houseService;
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
        System.out.println("从数据库得到的agent信息"+house);
        mv.addObject("house", house);
        mv.setViewName("house-update");
        return mv;
    }

    @RequestMapping(path = "/update.do")
    public String update(House house) {
        System.out.println("表现层从表单接受到的信息：" + house);
        houseService.update(house);
        return "redirect:/house/findAllBypagesBack.do";
    }

    @RequestMapping(path = "/soldout")
    @CrossOrigin(origins = "*")
    public @ResponseBody String setSoldOut(int houseId){
        System.out.println("表现层正在执行修改房屋状态:"+houseId);
        House house = houseService.getHouseById(houseId);
        house.setStatus(3);
        houseService.update(house);
        return "OK!";
    }

    @RequestMapping(path = "/getHouseById")
    @CrossOrigin(origins = "*")
    public @ResponseBody
    String findHouseById(int hid) {
        System.out.println("表现层正在执行查询具体房源信息...");
        System.out.println(hid);
        House house = houseService.getHouseById(hid);
        if (null != house) {
            String result = JSON.toJSONString(house);
            return result;
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


        int userId = Integer.parseInt((String)jsonData.get("user"));
        String housePicture = (String)jsonData.get("picture");
        String address = (String)jsonData.get("properties");
        int unitPrice = Integer.parseInt((String)jsonData.get("unit_price"));
        int area = Integer.parseInt((String) jsonData.get("area"));

        int floor = Integer.parseInt((String)jsonData.get("floor"));
        String description =(String)jsonData.get("description");
        int hasLift = Integer.parseInt((String) jsonData.get("lift"));
        int type = Integer.parseInt((String) jsonData.get("is_for_sell"));

        String houseHead = (String)jsonData.get("title");

        int houseRoomnun = Integer.parseInt((String)jsonData.get("room_num"));
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
        house.setDescription(description);
        house.setHasLift(hasLift);
        house.setType(type);








//        System.out.println("type:"+type.toString());
//        System.out.println("houseHead:"+houseHead);
//        System.out.println("description:"+description);
//        System.out.println("address:"+address);


        return "success";

    }




    
    @RequestMapping(path = "/getHouseByUid")
    @CrossOrigin(origins = "*")
    public @ResponseBody
    String findHouseByUid(@RequestParam(value = "id", required = true) int id ) {
        System.out.println("表现层正在执行查询具体房源信息...");
        List<House> houses = houseService.getHouseByUserId(id);
        if (null != houses) {
            String result = JSON.toJSONString(houses);
            return result;
        }
        return null;
    }

}
