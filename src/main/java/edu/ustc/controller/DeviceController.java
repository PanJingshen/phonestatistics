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
@RequestMapping("/device")
public class DeviceController {
	
	
	@Resource(name="deviceServiceImpl")
	private DeviceService deviceService;
	
	
	private static final String TAG = DeviceController.class.getSimpleName();
	
	@RequestMapping(value="/client/upload", method = RequestMethod.POST)
	@ResponseBody
	private int upload(HttpServletRequest request, Model model){
		String json = request.getParameter("device");
//		System.out.println(TAG+json);
		Gson gson = new Gson();
		Device device = gson.fromJson(json, Device.class);
		System.out.println(TAG+device.toString());
		deviceService.upload(device);
		return deviceService.getDeviceId(device.getAndroidId());
	
	}
	
	@RequestMapping(value="/getDevice", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	private Device getDevice(String androidId){
		System.out.println(TAG+"getDevice");
		Device device = deviceService.getDevice(androidId);
		return device;
	}
	
	@RequestMapping(value="/getDevices", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	private List<Device> getDevices(HttpServletRequest request, Model model){
		System.out.println(TAG+"getDevices");
		List<Device> dList = deviceService.getDevices();
		model.addAttribute("device", dList);
		return dList;
	}
	
	@RequestMapping(value="/getDevicesByUserId", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	private List<Device> getDevices(int userId){
		System.out.println(TAG+"getDevices");
		List<Device> dList = deviceService.getDevices();
		return dList;
	}
	
	@RequestMapping(value="/updateDevice", method = {RequestMethod.POST, RequestMethod.GET})
	private String updateDevice(HttpServletRequest request, Model model){
		System.out.println(TAG+"updateDevice");
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String birthdate = request.getParameter("birthdate");
		
		Device device = new Device();
		
		System.out.println(TAG+device.toString());
		
		boolean isSuccess = deviceService.updateDevice(device);
		return "redirect:index";
	}
	
	@RequestMapping(value="/deleteDevice", method = {RequestMethod.POST, RequestMethod.GET})
	private String deleteDevice(HttpServletRequest request, Model model){
		int id = Integer.parseInt(request.getParameter("id"));

		if (deviceService.deleteDevice(id)==true) {
			return "redirect:index";
		}
		return "redirect:index";
	}
}
