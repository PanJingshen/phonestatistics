package edu.ustc.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import edu.ustc.model.UsageStats;
import edu.ustc.service.UsageStatsService;
import util.NetUtil;

@Controller
@RequestMapping("/usage_stats")
public class UsageStatsController {
	
	@Resource(name="usageStatsServiceImpl")
	private UsageStatsService usageStatsService;
	
	
	private static final String TAG = UsageStatsController.class.getSimpleName();
	
	@RequestMapping(value="/client/upload", method = RequestMethod.POST)
	private void upload(HttpServletRequest request, Model model){
		String json = request.getParameter("usage_stats_list");
		System.out.println(TAG+json);
		
		Type type = new TypeToken<List<UsageStats>>(){}.getType();
		Gson gson = new Gson();
		List<UsageStats> uList = gson.fromJson(json, type);
		System.out.println(TAG+uList.toString());
		usageStatsService.upload(uList);
		
	
	}
	
	/**
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/getUsageStats", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	private List<UsageStats> getUsageStats(HttpServletRequest request, Model model){
		System.out.println(TAG+"getUsageStats");
		List<UsageStats> uList = usageStatsService.getUsageStats();
		model.addAttribute("usage_stats", uList);
		return uList;
	}
	
	@RequestMapping(value="/addWakeLocks", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	private List<UsageStats> addWakeLocks(HttpServletRequest request, Model model){
		System.out.println(TAG+"getUsageStats");
		List<UsageStats> uList = usageStatsService.getUsageStats();
		model.addAttribute("usage_stats", uList);
		return uList;
	}
	
}
