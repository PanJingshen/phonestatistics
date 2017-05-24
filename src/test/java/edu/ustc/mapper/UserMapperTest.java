package edu.ustc.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.ustc.mapper.UserMapper;
import edu.ustc.model.User;

public class UserMapperTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testGetUserByName() {
		String username="123";
		User user = userMapper.getUserByName(username);
		
		System.out.println(user.toString());
	}

}
