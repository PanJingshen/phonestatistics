package edu.ustc.service.impl;

import java.util.List;

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

	@Override
	public List<Device> getDevices() {
		
		return deviceDao.getDevices();
	}

	@Override
	public boolean updateDevice(Device device) {
		if (deviceDao.updateByPrimaryKey(device) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteDevice(int id) {
		if (deviceDao.deleteByPrimaryKey(id) > 0) {
			return true;
		}
		return false;
	}


	@Override
	public Device getDevice(String androidId) {
		
		return deviceDao.selectByAndroidId(androidId);
	}
}
