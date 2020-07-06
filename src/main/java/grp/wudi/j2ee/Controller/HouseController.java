package grp.wudi.j2ee.Controller;

import grp.wudi.j2ee.entity.House;
import grp.wudi.j2ee.service.impl.HouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path="/house")
public class HouseController {
    @Autowired
    private HouseServiceImpl houseService;

    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<House> list = houseService.findAll();
        mv.addObject("",list);
        mv.setViewName("");
        return mv;
    }
    
    /**
	 * 删除房屋信息
	 */
	@RequestMapping(path = "/delete")
	public String delete(@RequestParam(value = "id", required = true) int id) {
		House removeHouse = houseService.getHouseById(id);
		houseService.delete(id);
		id = removeHouse.getUserId();
		String redirect = "redirect:/user/order?id="+id;
		return redirect;
	}
}
