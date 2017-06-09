package edu.ustc.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.view.facelets.Tag;
import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;

import org.omg.IOP.TAG_ALTERNATE_IIOP_ADDRESS;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.ustc.model.User;
import edu.ustc.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final String TAG = UserController.class.getSimpleName();

	@Resource(name="userServiceImpl")
	private UserService userService;
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	private String login(HttpServletRequest request, Model model){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (userService.isLogin(username, password)==true) {
			return "user/index";
		}
		return "user/index";
	}
	
	@RequestMapping(value="/index")
	private String index(Model model) {
		System.out.println(TAG+"index");
//		model.addAttribute("user", );
		return "index";
	}

	
	@RequestMapping(value="/addUser", method = {RequestMethod.POST, RequestMethod.GET})
	private String addUser(HttpServletRequest request, Model model){
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
//		String brithdate= request.getParameter("brithdate");
		System.out.println(username+password);
		if (userService.register(username, email, password)==true) {
			return "redirect:index";
		}
		return "redirect:index";
	}
	
	@RequestMapping(value="/getUsers", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	private List<User> getUsers(HttpServletRequest request, Model model){
		System.out.println(TAG+"getUsers");
		List<User> uList = userService.getUsers();
		return uList;
	}
	
	
	@RequestMapping(value="/getUsersByUsername", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	private List<User> getUsers(String username){
		System.out.println(TAG+"getUsers");
		List<User> uList = userService.getUsers(username);
		return uList;
	}
	
	@RequestMapping(value="/updateUser", method = {RequestMethod.POST, RequestMethod.GET})
	private String updateUser(HttpServletRequest request, Model model){
		System.out.println(TAG+"updateUser");
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String birthdate = request.getParameter("birthdate");
		
		User user = new User(id, username, email, password);
		
		System.out.println(TAG+user.toString());
		
		boolean isSuccess = userService.updateUser(user);
		return "redirect:index";
	}
	
	@RequestMapping(value="/deleteUser", method = {RequestMethod.POST, RequestMethod.GET})
	private String deleteUser(HttpServletRequest request, Model model){
		int id = Integer.parseInt(request.getParameter("id"));

		if (userService.deleteUser(id)==true) {
			return "redirect:index";
		}
		return "redirect:index";
	}
	
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	private String register(HttpServletRequest request, Model model){
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println(username+password);
		if (userService.register(username, email, password)==true) {
			return "user/index";
		}
		return "user/index";
	}
	
	@RequestMapping(value="client/login", method = RequestMethod.POST)
	@ResponseBody
	private HashMap<String, Object> client_login(HttpServletRequest request, Model model){
		String username = request.getParameter("username");
		String password = request.getParameter("password");


//		System.out.println("UserController======================"+username+password);
		if (userService.isLogin(username, password)==true) {
			User user = userService.getUser(username);
			HashMap<String, Object> map_user = new HashMap<>();
			map_user.put("id", user.getId());
			map_user.put("username", user.getUsername());
			map_user.put("email", user.getEmail());
			map_user.put("password", user.getPassword());
			System.out.println(map_user.toString());
			return map_user;
		}
		return null;
	}
	
	@RequestMapping(value="client/getUser", method = RequestMethod.POST)
	@ResponseBody
	private HashMap<String, Object> client_getUser(HttpServletRequest request, Model model){
		String username = request.getParameter("username");
		User user = userService.getUser(username);
		HashMap<String, Object> map_user = new HashMap<>();
		map_user.put("id", user.getId());
		map_user.put("username", user.getUsername());
		map_user.put("email", user.getEmail());
		map_user.put("password", user.getPassword());
		System.out.println(map_user.toString());
		return map_user;
	}
	
	@RequestMapping(value="client/getUserById", method = RequestMethod.POST)
	@ResponseBody
	private HashMap<String, Object> client_getUserById(HttpServletRequest request, Model model){
		int id = Integer.parseInt(request.getParameter("id"));
		User user = userService.getUserById(id);
		HashMap<String, Object> map_user = new HashMap<>();
		map_user.put("id", user.getId());
		map_user.put("username", user.getUsername());
		map_user.put("email", user.getEmail());
		map_user.put("password", user.getPassword());
		System.out.println(map_user.toString());
		return map_user;
	}
	
	@RequestMapping(value="client/register", method = RequestMethod.POST)
	@ResponseBody
	private boolean client_register(HttpServletRequest request, Model model){
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println("UserController======================client_register:"+username+email+password);
		return userService.register(username, email, password);
	}
	
}
