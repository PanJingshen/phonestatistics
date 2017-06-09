package edu.ustc.mapper;

import java.util.List;

import edu.ustc.model.User;

public interface UserMapper {
	
	public User getUserByName(String username);
	
	public int insert(User user);

	public List<User> getUsers();

	public void deleteById(int id);

	public void updateById(User user);

	public List<User> getUsersByName(String username);

	public User getUserById(int id);
}
