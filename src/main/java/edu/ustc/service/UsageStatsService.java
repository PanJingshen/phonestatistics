package edu.ustc.service;

import java.util.List;

import edu.ustc.model.UsageStats;

public interface UsageStatsService {
	public void upload(List<UsageStats> uList);

	public List<UsageStats> getUsageStats();
}
