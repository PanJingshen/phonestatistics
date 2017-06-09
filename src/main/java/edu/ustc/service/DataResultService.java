package edu.ustc.service;

import edu.ustc.model.DataResult;
import edu.ustc.model.DataResultWithBLOBs;
public interface DataResultService {

	public DataResultWithBLOBs getDataResult(int deviceId);
}
