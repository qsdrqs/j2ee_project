package grp.wudi.j2ee.Controller;


import grp.wudi.j2ee.entity.User;
import grp.wudi.j2ee.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserServiceImpl userService;

    /**
     * 查询所有用户信息
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/findAll")
    public String findAll(Model model) throws Exception {
        System.out.println("表现层执行了查询所有用户信息");
        List<User> list = userService.findAll();
        model.addAttribute("list",list);
        return "user-list";
    }


    @RequestMapping(path = "/findAll1")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv =new ModelAndView();

        System.out.println("表现层执行了查询所有用户信息");
        List<User> list = userService.findAll();
        mv.addObject("list",list);
        mv.setViewName("user-list");
        return mv;
    }
    /**
     * 保存用户信息
     */
    @RequestMapping(path = "/save")
    public void save(User user, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("表现层执行了保存用户...");
        userService.add(user);
        request.getRequestDispatcher("/user/findAll").forward(request,response);
    }

    @RequestMapping(path = "/add")
    public void add(User user, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("表现层执行了保存用户...");
        userService.add(user);
        request.getRequestDispatcher("/user/findAll").forward(request,response);
    }
}
