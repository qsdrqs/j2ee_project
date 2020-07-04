package grp.wudi.j2ee.Controller;

import grp.wudi.j2ee.entity.House;
import grp.wudi.j2ee.service.impl.HouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
