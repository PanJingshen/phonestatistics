package edu.ustc.mapper;

import edu.ustc.model.Device;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);

    Device selectByAndroidId(String androidId);
}