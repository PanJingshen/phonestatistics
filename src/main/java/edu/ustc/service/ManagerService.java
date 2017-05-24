package edu.ustc.service;


import java.util.List;

import edu.ustc.model.Manager;

public interface ManagerService {
	public boolean isLogin(String username, String password);
	public Manager getManager(String username);
	boolean register(String username, String email, String password, String phone);
	public List<Manager> getManagers();
	public void addManager(Manager manager);
	public void updateManager(Manager manager);
	public void deleteManager(int id);
	public void getManager(int id);
}
