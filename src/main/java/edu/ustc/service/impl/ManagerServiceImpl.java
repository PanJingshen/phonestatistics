package edu.ustc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ustc.mapper.ManagerMapper;
import edu.ustc.mapper.UserMapper;
import edu.ustc.model.Manager;
import edu.ustc.model.User;
import edu.ustc.service.ManagerService;
import edu.ustc.service.UserService;


@Service("managerServiceImpl")
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	private ManagerMapper managerDao;
	
	public boolean isLogin(String username, String password) {
		Manager manager = managerDao.selectByUsername(username);
//		System.out.println("UserserviceImpl=-================"+user.toString());
		if (manager.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	

	@Override
	public Manager getManager(String username) {
		Manager manager = managerDao.selectByUsername(username);
		return manager;
	}

	@Override
	public boolean register(String username, String email, String password, String phone) {
		Manager manager =managerDao.selectByUsername(username);
		// 先判断用户名是否已占用
		if (manager==null) {
			manager = new Manager(username, password, email,phone);
			int isRegister = managerDao.insert(manager);
			System.out.println(isRegister);
			if (isRegister==1) {
				return true;
			}
		}
		return false;
	}



	@Override
	public List<Manager> getManagers() {
		return managerDao.getManagers();
	}



	@Override
	public void addManager(Manager manager) {
		managerDao.insert(manager);
		
	}



	@Override
	public void updateManager(Manager manager) {
		managerDao.updateByPrimaryKey(manager);
		
	}



	@Override
	public void deleteManager(int id) {
		managerDao.deleteByPrimaryKey(id);
		
	}



	@Override
	public Manager getManager(int id) {
		return managerDao.selectByPrimaryKey(id);
	}


	

}
