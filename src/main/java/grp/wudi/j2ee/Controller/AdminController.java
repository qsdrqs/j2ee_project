package grp.wudi.j2ee.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

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
			int id = adminService.findAdminId(admin.getAdminAccount());
			int type = adminService.findAdminType(admin.getAdminAccount());
			admin.setAdminId(id);
			admin.setType(type);
			session.setAttribute("adminInfo", admin);
			return "redirect:/main.do";
		} else {
			model.addAttribute("msg","用户名或密码错误");
			return "redirect:/login.jsp";
		}
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("adminInfo");
        return "redirect:/main.do";

	}
	
	/**
	 * 	管理员自己修改信息
	 */
	@RequestMapping(path = "/update.do")
	public String update(@RequestParam(value = "id", required = true) int id, Model model) {
		Admin admin = adminService.getAdminById(id);
		model.addAttribute("admin", admin);
		return "adminInfo";
	}

	@PostMapping("/update.do")
	public String update(Admin admin) {
		adminService.update(admin);
		return "adminInfo";
	}
	
	/**
	 * 	访问角色管理
	 * 	只有超级管理员可以访问
	 */
	@RequestMapping(path = "/manage.do")
	public String manage(@RequestParam(value = "type", required = true) int type, Model model) {
		if(1 == type) {
			return "redirect:/admin/findAll.do";
		}
		return "redirect:/main.do";
	}
	
	/**
	 * 	查询所有管理员信息
	 */
	@RequestMapping(path = "/findAll.do")
	public String findAll(@RequestParam(value = "p", defaultValue = "1") int p, Model model) throws Exception {
		PageInfo<Admin> pi = adminService.finAll(p);
		model.addAttribute("pi", pi);
		return "admin-list";
	}
	
	/**
	 * 	删除用户信息
	 */
	@RequestMapping(path = "/delete.do")
	public String delete(@RequestParam(value = "id", required = true) int id) {
		adminService.deleteAdmin(id);
		return "redirect:/admin/findAll.do";
	}
	
	/**
	 * 	增加管理员信息
	 */
	@RequestMapping("/adminAdd.do")
	public ModelAndView goHome() {
        ModelAndView mav =new ModelAndView("admin-add");
        return mav;
    }
	
	@RequestMapping(path = "/add" ,method = RequestMethod.POST)
	public String addAuser(Admin admin) {
		adminService.addAdmin(admin);
		return "redirect:/admin/findAll.do";
	}
	
	/**
	 * 	超级管理员修改管理员信息
	 */
	@RequestMapping(path = "/edit.do")
	public String edit(@RequestParam(value = "id", required = true) int id, Model model) {
		Admin admin = adminService.getAdminById(id);
		model.addAttribute("admin", admin);
		return "adminInfoEdit";
	}

	@PostMapping("/edit.do")
	public String edit(Admin admin) {
		adminService.update(admin);
		return "redirect:/admin/findAll.do";
	}
}
