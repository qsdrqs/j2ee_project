package grp.wudi.j2ee.Controller;

import com.github.pagehelper.PageInfo;
import grp.wudi.j2ee.entity.Agent;
import grp.wudi.j2ee.entity.House;
import grp.wudi.j2ee.service.impl.HouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping(path="/house")
public class HouseController {
    @Autowired
    private HouseServiceImpl houseService;
    @RequestMapping(path = "/findAllHouse")
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
    @RequestMapping(path="/findAllBypages")
    public String findAllBypages(@RequestParam(value = "p", defaultValue = "1") int p, Model model) throws Exception {
        System.out.println("表现层正在执行分页查询房源信息....");
        PageInfo<House> pi = houseService.findAll(p);
        model.addAttribute("pi", pi);
        return "house-list";
    }
    /**
	 * 删除房屋信息
	 */
	@RequestMapping(path = "/delete")
	public String delete(@RequestParam(value = "id", required = true) int id) {
		House removeHouse = houseService.getHouseById(id);
		houseService.delete(id);
		id = removeHouse.getUserId();
        return "redirect:/house/findAllBypages";
	}
}
