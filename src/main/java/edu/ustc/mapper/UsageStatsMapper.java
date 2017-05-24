package edu.ustc.mapper;

import edu.ustc.model.UsageStats;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsageStatsMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UsageStats record);

    int insertSelective(UsageStats record);

    UsageStats selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UsageStats record);

    int updateByPrimaryKey(UsageStats record);
}