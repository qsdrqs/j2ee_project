package grp.wudi.j2ee.Controller;

import grp.wudi.j2ee.entity.House;
import grp.wudi.j2ee.entity.User;
import grp.wudi.j2ee.service.impl.HouseServiceImpl;
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
	@Autowired
	private HouseServiceImpl houseService;

	/**
	 * 查询所有用户信息
	 */
	@RequestMapping(path = "/findAll")
	public String findAll(@RequestParam(value = "p", defaultValue = "1") int p, Model model) throws Exception {
		PageInfo<User> pi = userService.finAll(p);
		model.addAttribute("pi", pi);
		return "user-list";
	}

	/**
	 * 删除用户信息
	 */
	@RequestMapping(path = "/delete")
	public String delete(@RequestParam(value = "id", required = true) int id) {
		userService.deleteUser(id);
		return "redirect:/user/findAll";
	}

	/**
	 * 修改用户信息
	 */
	@RequestMapping(path = "/update")
	public String update(@RequestParam(value = "id", required = true) int id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "user-update";
	}

	@PostMapping("/update")
	public String update(User user) {
		userService.update(user);
		return "redirect:/user/findAll";
	}

	/*
	 * 增加用户信息
	 */
	@RequestMapping(path = "/add")
	public String addAuser(User user) {
		userService.add(user);
		return "redirect:/user/findAll";
	}

	/*
	 * 查看用户订单
	 */
	@RequestMapping(path = "/order")
	public String trackOrder(@RequestParam(value = "id", required = true) int id,
			@RequestParam(value = "p", defaultValue = "1") int p, Model model) {
		PageInfo<House> pi = houseService.getHouseByUserId(id, p);
		model.addAttribute("pi", pi);
		return "order-form";
	}
	
//	@RequestMapping(path = "/order")
//	public String trackOrder(@RequestParam(value = "id", required = true) int id, Model model) {
//		List<House> houses = houseService.getHouseByUserId(id);
//		System.out.println(houses);
//		model.addAttribute("houses", houses);
//		return "order-form";
//	}
}
