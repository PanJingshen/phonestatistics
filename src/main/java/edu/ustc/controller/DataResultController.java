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

import edu.ustc.model.DataResult;
import edu.ustc.model.DataResultWithBLOBs;
import edu.ustc.service.DataResultService;

@Controller
@RequestMapping("/data_result")
public class DataResultController {
	
	
	@Resource(name="dataResultServiceImpl")
	private DataResultService dataResultService;
	
	
	private static final String TAG = DataResultController.class.getSimpleName();
	
	
	@RequestMapping(value="/getDataResult", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	private DataResultWithBLOBs getDataResult(HttpServletRequest request, Model model){
		int deviceId = Integer.parseInt(request.getParameter("deviceId"));
		System.out.println(TAG+"getDataResult"+"  params:"+deviceId);
		DataResultWithBLOBs dataResult = dataResultService.getDataResult(deviceId);
		System.out.println(dataResult);
		return dataResult;
	}
	
	
	
	

}
