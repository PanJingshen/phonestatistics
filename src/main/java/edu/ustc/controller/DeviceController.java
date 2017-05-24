package edu.ustc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.faces.view.facelets.Tag;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.objenesis.instantiator.gcj.GCJSerializationInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import edu.ustc.model.Device;
import edu.ustc.service.DeviceService;
import edu.ustc.service.UserService;

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
		System.out.println(TAG+json);
		Gson gson = new Gson();
		Device device = gson.fromJson(json, Device.class);
		System.out.println(TAG+device.toString());
		deviceService.upload(device);
		return deviceService.getDeviceId(device.getAndroidId());
	
	}
}
