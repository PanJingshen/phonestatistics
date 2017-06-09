package edu.ustc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ustc.mapper.DataResultMapper;
import edu.ustc.mapper.DeviceMapper;
import edu.ustc.mapper.UserMapper;
import edu.ustc.model.DataResult;
import edu.ustc.model.DataResultWithBLOBs;
import edu.ustc.model.Device;
import edu.ustc.service.DataResultService;
import edu.ustc.service.DeviceService;

@Service("dataResultServiceImpl")
public class DataResultServiceImpl implements DataResultService{
	
	@Autowired
	private DataResultMapper dataResultDao;

	@Override
	public DataResultWithBLOBs getDataResult(int deviceId) {
		return dataResultDao.selectByDeviceId(deviceId);
	}
}
