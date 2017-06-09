package edu.ustc.mapper;

import edu.ustc.model.DataResult;
import edu.ustc.model.DataResultWithBLOBs;

public interface DataResultMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(DataResultWithBLOBs record);

    int insertSelective(DataResultWithBLOBs record);

    DataResultWithBLOBs selectByPrimaryKey(Integer id);
    
    DataResultWithBLOBs selectByDeviceId(Integer deviceId);
    
    int updateByPrimaryKeySelective(DataResultWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DataResultWithBLOBs record);

    int updateByPrimaryKey(DataResult record);
}