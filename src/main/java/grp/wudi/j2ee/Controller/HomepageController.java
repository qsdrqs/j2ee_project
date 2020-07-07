package grp.wudi.j2ee.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomepageController {
	@RequestMapping("/main.do")
	public ModelAndView goHome() {
        ModelAndView mav =new ModelAndView("main");
        return mav;
    }
}
