package edu.ustc.service;

import edu.ustc.model.Device;

public interface DeviceService {
	public void upload(Device device);

	public int getDeviceId(String androidId);
}
