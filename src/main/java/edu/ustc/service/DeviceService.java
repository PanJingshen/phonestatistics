package edu.ustc.service;

import java.util.List;

import edu.ustc.model.Device;

public interface DeviceService {
	public void upload(Device device);

	public int getDeviceId(String androidId);

	public List<Device> getDevices();

	public boolean updateDevice(Device device);

	public boolean deleteDevice(int id);

	public Device getDevice(String androidId);
}
