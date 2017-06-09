package edu.ustc;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.ustc.mapper.DataResultMapper;
import edu.ustc.mapper.UserMapper;
import edu.ustc.model.DataResultWithBLOBs;
import edu.ustc.model.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mvc.xml", "classpath:spring-mybatis.xml"})
public class BestTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private DataResultMapper dataResultMapper;
	
//	@Test
//	public void testGetUsers() {
//		
//		List<User> uList = userMapper.getUsers();
//		
//		System.out.println(uList.toString());
//	}
	
//	@Test
//	public void testDeleteUser() {
//		
//		userMapper.deleteById(5);
//	}
	
//	@Test
//	public void testgetDataResult() {
//		
//		DataResultWithBLOBs dataResultWithBLOBs = dataResultMapper.selectByDeviceId(5);
//		
//		System.out.println(dataResultWithBLOBs);
//	}
//	
	
	@Test
	public void testGetUsersByName() {
		String username="1";
		List<User> userList = userMapper.getUsersByName(username);
		
		System.out.println("test:"+userList.toString());
	}
	
//	@Test
//	public void testAddUser() {
//		User user = new User("3123", "3123");
//		int i = userMapper.insert(user);
//		System.out.println(i);
//	}
}
