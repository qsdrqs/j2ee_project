package grp.wudi.j2ee.Controller;

import grp.wudi.j2ee.entity.House;
import grp.wudi.j2ee.entity.User;
import grp.wudi.j2ee.service.impl.HouseServiceImpl;
import grp.wudi.j2ee.service.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private HouseServiceImpl houseService;

	/**
	 * 查询所有用户信息
	 */
	@RequestMapping(path = "/findAll.do")
	public String findAll(@RequestParam(value = "p", defaultValue = "1") int p, Model model) throws Exception {
		PageInfo<User> pi = userService.finAll(p);
		model.addAttribute("pi", pi);
		return "user-list";
	}

	/**
	 * 模糊查询用户信息
	 */
	@RequestMapping(path = "/search.do")
	public String search(String msg, @RequestParam(value = "p", defaultValue = "1") int p, Model model)
			throws Exception {
		PageInfo<User> pi = userService.getUserByKeyword(msg, p);
		model.addAttribute("pi", pi);
		return "user-searchlist";

	}

	/**
	 * 删除用户信息
	 */
	@RequestMapping(path = "/delete.do")
	public String delete(@RequestParam(value = "id", required = true) int id) {
		userService.deleteUser(id);
		return "redirect:/user/findAll.do";
	}

	/**
	 * 修改用户信息
	 */
	@RequestMapping(path = "/update.do")
	public String update(@RequestParam(value = "id", required = true) int id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "user-update";
	}

	@PostMapping("/update.do")
	public String update(User user) {
		userService.update(user);
		return "redirect:/user/findAll.do";
	}

	/*
	 * 增加用户信息
	 */
	@RequestMapping("/userAdd.do")
	public ModelAndView goHome() {
		ModelAndView mav = new ModelAndView("user-add");
		return mav;
	}

	@RequestMapping(path = "/add.do")
	public String addAuser(User user) {
		userService.add(user);
		return "redirect:/user/findAll.do";
	}

	/*
	 * 查看用户订单
	 */
	@RequestMapping(path = "/order.do")
	public String trackOrder(@RequestParam(value = "id", required = true) int id,
			@RequestParam(value = "p", defaultValue = "1") int p, Model model) {
		PageInfo<House> pi = houseService.getHouseByUserId(id, p);
		model.addAttribute("pi", pi);
		return "order-form";
	}

	@RequestMapping(path = "/userLogin")
	@CrossOrigin(origins = "*")
	public @ResponseBody String verifyUser(@RequestBody String data) {
		JSONObject jsonData = JSONObject.parseObject(data);
		String userAccount = (String) jsonData.get("userAccount");
		String userPassword = (String) jsonData.get("userPasswordsha256");
		User user = userService.verifyUser(userAccount, userPassword);
		if (null != user) {
			String result = JSON.toJSONString(user);
			System.out.println(result);
			return result;
		} else {
			System.out.println("验证失败!!!");
			return null;
		}
	}

}
