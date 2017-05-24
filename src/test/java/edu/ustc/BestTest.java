package edu.ustc;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.ustc.mapper.UserMapper;
import edu.ustc.model.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mvc.xml", "classpath:spring-mybatis.xml"})
public class BestTest {
	
	@Autowired
	private UserMapper userMapper;
	
//	@Test
//	public void testGetUsers() {
//		
//		List<User> uList = userMapper.getUsers();
//		
//		System.out.println(uList.toString());
//	}
	
	@Test
	public void testDeleteUser() {
		
		userMapper.deleteById(5);
	}
//	@Test
//	public void testGetUserByName() {
//		String username="123";
//		User user = userMapper.getUserByName(username);
//		
//		System.out.println(user.toString());
//	}
	
//	@Test
//	public void testAddUser() {
//		User user = new User("3123", "3123");
//		int i = userMapper.insert(user);
//		System.out.println(i);
//	}
}
