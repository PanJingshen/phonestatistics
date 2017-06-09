package edu.ustc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.faces.view.facelets.Tag;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;

import org.omg.IOP.TAG_ALTERNATE_IIOP_ADDRESS;
import org.springframework.objenesis.instantiator.gcj.GCJSerializationInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import edu.ustc.model.Device;
import edu.ustc.service.DeviceService;

@Controller
@RequestMapping("/nav")
public class NavController {
	
	
	
	
	private static final String TAG = NavController.class.getSimpleName();
	
	@RequestMapping(value="/index", method = {RequestMethod.POST, RequestMethod.GET})
	private String navIndex(HttpServletRequest request, Model model){
		return "index";
	}
	
	@RequestMapping(value="/login", method = {RequestMethod.POST, RequestMethod.GET})
	private String navLogin(HttpServletRequest request, Model model){
		return "login";
	}
	
	@RequestMapping(value="/user_list", method = {RequestMethod.POST, RequestMethod.GET})
	private String navUserList(HttpServletRequest request, Model model){
		return "user_list";
	}
	
	@RequestMapping(value="/manager_list", method = {RequestMethod.POST, RequestMethod.GET})
	private String navManagerList(HttpServletRequest request, Model model){
		return "manager_list";
	}
	
	@RequestMapping(value="/usagestats_list", method = {RequestMethod.POST, RequestMethod.GET})
	private String navUsageStatsList(HttpServletRequest request, Model model){
		return "usagestats_list";
	}
	
	@RequestMapping(value="/device_list", method = {RequestMethod.POST, RequestMethod.GET})
	private String navDeviceList(HttpServletRequest request, Model model){
		return "device_list";
	}
	
	@RequestMapping(value="/data_result", method = {RequestMethod.POST, RequestMethod.GET})
	private String navDataResult(HttpServletRequest request, Model model){
		return "data_result";
	}
	
}
