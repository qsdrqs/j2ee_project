package grp.wudi.j2ee.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import grp.wudi.j2ee.entity.Admin;
import grp.wudi.j2ee.service.AdminService;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	/**
	 * 验证登录
	 * 
	 * @param admin    admin输入账号和密码封装成admin对象
	 * @param request 登录成功时将admin存入session当中
	 * @return 登录成功后跳转至首页
	 */
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String checked(Admin admin, Model model,HttpSession session) {
		if (adminService.checkAdmin(admin)) {
			session.setAttribute("adminInfo", admin);
			return "redirect:/main.do";
		} else {
			//model.addAttribute("msg","用户名或密码错误");
			return "redirect:/main.do";
		}
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("adminInfo");
        return "redirect:/main.do";

	}
}
