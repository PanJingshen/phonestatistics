package edu.ustc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.faces.view.facelets.Tag;
import javax.servlet.http.HttpServletRequest;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.omg.IOP.TAG_ALTERNATE_IIOP_ADDRESS;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.ustc.model.Manager;
import edu.ustc.model.User;
import edu.ustc.service.ManagerService;

@Controller
@RequestMapping("/manager")
@SessionAttributes(value={"manager"},types = {Manager.class})
public class ManagerController {

	@Resource(name="managerServiceImpl")
	private ManagerService managerService;
	
	private static final String TAG = ManagerController.class.getSimpleName();
	
	
	@RequestMapping(value="/doLogin")
	private String doLogin(String username, String password, Model model) {
		if (managerService.isLogin(username, password)) {
			model.addAttribute("manager", managerService.getManager(username));
			return "redirect:index";
		}
		return "redirect:login";
	}
	
	@RequestMapping(value="/login")
	private String login() {
		return "login";
	}
	
	@RequestMapping(value="/index")
	private String index(Model model) {
		System.out.println(TAG+"index");
//		model.addAttribute("user", );
		return "index";
	}
	
	@RequestMapping(value="/manager_list")
	private String managerList(Model model) {
		System.out.println(TAG+"index");
//		model.addAttribute("user", );
		return "manager_list";
	}
	
	/**
	 * 添加管理员预处理
	 * @param manager
	 * @return
	 */
	@RequestMapping(value="/addPrompt")
	private String addPrompt(Manager manager) {
		managerService.addManager(manager);
		return "redirect:index";
	}
	
	@RequestMapping(value="/addManager")
	private String addManager(Manager manager) {
		managerService.addManager(manager);
		return "redirect:manager_list";
	}
	
	@RequestMapping(value="/getManager")
	private Manager getManager(int id) {
		
		return managerService.getManager(id);
	}
	
	@RequestMapping(value="/getManagers")
	@ResponseBody
	public List<Manager> getManagers() {
		return managerService.getManagers();
	}
	
	@RequestMapping(value="/updateManager")
	private String updateManager(Manager manager) {
		managerService.updateManager(manager);
		return "redirect:manager_list";
	}
	
	@RequestMapping(value="/deleteManager")
	private String deleteManager(int id) {
		managerService.deleteManager(id);
		return "redirect:manager_list";
	}
	
}
