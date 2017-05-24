package edu.ustc.mapper;

import edu.ustc.model.Manager;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManagerMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);

	Manager selectByUsername(String username);
}