package edu.ustc.service;

import java.util.List;

import org.codehaus.jackson.map.ser.std.StdArraySerializers.BooleanArraySerializer;

import edu.ustc.model.User;

public interface UserService {
	public boolean isLogin(String username, String password);
	public boolean register(String username, String email, String password);
	public User getUser(String username);
	public List<User> getUsers();
	public boolean deleteUser(int id);
	public boolean updateUser(User user);
}
