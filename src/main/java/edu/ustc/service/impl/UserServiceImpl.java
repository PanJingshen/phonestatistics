package edu.ustc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import edu.ustc.mapper.UserMapper;
import edu.ustc.model.User;
import edu.ustc.service.UserService;


@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userDao;
	
	public boolean isLogin(String username, String password) {
		User user = userDao.getUserByName(username);
//		System.out.println("UserserviceImpl=-================"+user.toString());
		if (user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	

	@Override
	public User getUser(String username) {
		User user = userDao.getUserByName(username);
		return user;
	}

	@Override
	public boolean register(String username, String email, String password) {
		User user = userDao.getUserByName(username);
		// 先判断用户名是否已占用
		if (user==null) {
			user = new User(username, password, email);
			int isRegister = userDao.insert(user);
			System.out.println(isRegister);
			if (isRegister==1) {
				return true;
			}
		}
		return false;
	}



	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}



	@Override
	public boolean deleteUser(int id) {
		userDao.deleteById(id);
		return false;
	}



	@Override
	public boolean updateUser(User user) {
		userDao.updateById(user);
		return false;
	}

	

}
