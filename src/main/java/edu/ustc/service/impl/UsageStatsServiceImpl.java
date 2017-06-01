package edu.ustc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ustc.mapper.DeviceMapper;
import edu.ustc.mapper.UsageStatsMapper;
import edu.ustc.mapper.UserMapper;
import edu.ustc.model.Device;
import edu.ustc.model.UsageStats;
import edu.ustc.service.DeviceService;
import edu.ustc.service.UsageStatsService;

@Service("usageStatsServiceImpl")
public class UsageStatsServiceImpl implements UsageStatsService{
	
	@Autowired
	private UsageStatsMapper usageStatsDao;

	@Override
	public void upload(List<UsageStats> uList) {
		// TODO Auto-generated method stub
		for (UsageStats usageStats : uList) {
			usageStatsDao.insert(usageStats);
		}
		
	}

	@Override
	public List<UsageStats> getUsageStats() {
		return usageStatsDao.getUsageStats();
	}
}
