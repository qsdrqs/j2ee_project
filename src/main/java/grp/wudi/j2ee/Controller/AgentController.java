package grp.wudi.j2ee.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import grp.wudi.j2ee.entity.Agent;
import grp.wudi.j2ee.service.impl.AgentServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(path="/agent")
public class AgentController {
    @Autowired
    private AgentServiceImpl agentService;

    @RequestMapping(path = "/findAll")
    public ModelAndView findAll() {
        System.out.println("表现层执行了...");
        ModelAndView mv = new ModelAndView();
        List<Agent> list = agentService.findAll();
        mv.addObject("agentList", list);
        mv.setViewName("agent-list");
        return mv;
    }
    @RequestMapping(path="/findAll1")
    public String findAll(@RequestParam(value = "p", defaultValue = "1") int p,Model model) throws Exception {
        PageInfo<Agent> pi = agentService.finAll(p);
        model.addAttribute("pi", pi);
        return "agent-list";
    }

    @RequestMapping(path = "/findById")
    public ModelAndView findById(int id) {
        ModelAndView mv = new ModelAndView();
        Agent agent = agentService.findById(id);
        mv.addObject("agentInfo", agent);
        mv.setViewName("success");
        return mv;
    }
    
    /*
	 * 	增加用户信息
	 */
	@RequestMapping("/agentAdd.do")
	public ModelAndView goHome() {
        ModelAndView mav =new ModelAndView("agent-add");
        return mav;
    }

    @RequestMapping(path = "/addagent")
    public void addAgent(Agent agent, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("表现层执行了保存用户...");
        System.out.println("表现层从表单获取的agent :"+agent);
        agentService.addAgent(agent);
        request.getRequestDispatcher("/agent/findAll1").forward(request, response);
    }

    @RequestMapping(path = "/deleteAgent")
    public String deleteAgent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("表现层执行了删除操作");
        String id = request.getParameter("id");
        agentService.deleteAgent(Integer.parseInt(id));
        return "redirect:/agent/findAll1";
    }
    @RequestMapping(path = "/PreupdateAgent")
    public ModelAndView PreupdateAgent(int id) {
        System.out.println("业务层正在执行修改...");
        ModelAndView mv = new ModelAndView();
        Agent agent = agentService.findById(id);
        System.out.println("从数据库得到的agent信息"+agent);
        mv.addObject("agent", agent);
        mv.setViewName("agent-modify");
        return mv;
    }

    @RequestMapping(path = "/updateAgent")
    public String update(Agent agent) {
        System.out.println("表现层从表单接受到的信息：" + agent);
        System.out.println("/update agent");
        System.out.println(agent);
        agentService.updateAgent(agent);
        return "redirect:/agent/findAll1";
    }

    @RequestMapping(path = "/Agentlogin")
    @CrossOrigin(origins = "*")
    public @ResponseBody
    String verifyAgent(@RequestBody String data) {
        System.out.println("表现层正在执行经纪人经纪人验证登入...");
        System.out.println(data);
        JSONObject jsonData = JSONObject.parseObject(data);

        String agentAccount = (String)jsonData.get("agentAccount");
        String agentPassword = (String)jsonData.get("agentPassword");

        Agent agent = agentService.verifyAgent(agentAccount, agentPassword);
        if (null != agent) {
            String result = JSON.toJSONString(agent);
            System.out.println(result);
            return result;
        } else {
            System.out.println("验证失败!!!");
            return null;
        }
    }
}