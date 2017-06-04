package cn.service;


import java.util.List;

import cn.dao.NewDao;
import cn.daoimpl.NewDaoImpl;
import cn.domain.mainpage;

public class Userservice {
	private static NewDao userDAO = new NewDaoImpl();

	public static String findPackageflow(String account) {
		return userDAO.findPackageflow(account);
	}

	public static boolean updateMainPage(String account, String status,
			String accountway, String cycleTime, String balance,
			String packageflow, String withhold) {
		return userDAO.updateMainPage(account, status,
				accountway, cycleTime, balance,
				packageflow, withhold);
		
	}

	public List<mainpage> ShowAllMainPage() {
		return userDAO.ShowAllMainPage();
	}

	public void addTime(long l) {
		
		userDAO.addTime(l);
	}

	public static String findCycleTime(String account) {
	
		return userDAO.findCycleTime(account);
	}





}
