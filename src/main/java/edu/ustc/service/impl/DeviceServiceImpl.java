package edu.ustc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ustc.mapper.DeviceMapper;
import edu.ustc.mapper.UserMapper;
import edu.ustc.model.Device;
import edu.ustc.service.DeviceService;

@Service("deviceServiceImpl")
public class DeviceServiceImpl implements DeviceService{
	@Autowired
	private DeviceMapper deviceDao;

	@Override
	public void upload(Device device) {
		// 如果没有上传过，那么上传设备信息
		if(deviceDao.selectByAndroidId(device.getAndroidId()).equals(0))
			deviceDao.insert(device);
		
	}

	@Override
	public int getDeviceId(String androidId) {
		return deviceDao.selectByAndroidId(androidId).getId();
	}
}