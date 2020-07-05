package grp.wudi.j2ee.Controller;


import grp.wudi.j2ee.entity.User;
import grp.wudi.j2ee.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserServiceImpl userService;

    /**
     * 	查询所有用户信息
     */
    @RequestMapping(path = "/findAll")
    public String findAll(@RequestParam(value = "p", defaultValue = "1") int p,Model model) throws Exception {
    	PageInfo<User> pi = userService.finAll(p);
    	model.addAttribute("pi", pi);
        return "user-list";
    }
    
    /**
     * 	删除用户信息
     */
    @RequestMapping(path = "/delete")
    public String delete(@RequestParam(value="id",required=true )int id) {
        userService.deleteUser(id);
        return "redirect:/user/findAll";
    }

    /**
     * 	修改用户信息
     */
    @RequestMapping(path = "/update")
    public String update(@RequestParam(value="id",required=true) int id,Model model) {
    	User user = userService.getUserById(id);
    	System.out.println(user);
    	model.addAttribute("user",user);
    	return "user-update";
    }
    
    @PostMapping("/update")
	public String update(User user) {
		System.out.println(user);
		return "redirect:/user/findAll";
	}
    
}
