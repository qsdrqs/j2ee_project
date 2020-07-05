package grp.wudi.j2ee.Controller;

import com.github.pagehelper.PageInfo;
import grp.wudi.j2ee.entity.Agent;
import grp.wudi.j2ee.service.impl.AgentServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(path = "/addagent")
    public void addAgent(Agent agent, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("表现层执行了保存用户...");
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
        System.out.println("业务层执行了修改...");
        ModelAndView mv = new ModelAndView();
        Agent agent = agentService.findById(id);
        mv.addObject("agent", agent);
        mv.setViewName("agent-modify");
        return mv;
    }
    @RequestMapping(path = "/updateAgent")
     public String update(Agent agent) {

        agentService.updateAgent(agent);

        return "redirect:/agent/findAll1";
    }

}

