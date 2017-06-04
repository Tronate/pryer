package cn.service;


import java.util.List;

import cn.dao.UserDao;
import cn.daoimpl.UserDaoImpl;
import cn.domain.User;
import cn.domain.mainpage;
import cn.domain.netRecord;
import cn.domain.userInfo;
import cn.domain.zhangWu;

public class model {
	
	private static UserDao userDAO = new UserDaoImpl();

	public boolean addMainpage(mainpage main) {
		return userDAO.addMainpage(main);
	}

	public boolean addRecordpage(netRecord record) {
		return userDAO.addMainpage(record);
	}

/*	public boolean addSelfBillPage(selfBill selfbill) {
		return userDAO.addSelfBillPage(selfbill);
	}*/

	public boolean addZhangWupage(zhangWu zhangwu) {
		return userDAO.addZhangWupage(zhangwu);
	}

	public boolean userInfo(userInfo user) {
		return userDAO.addUserInfo(user);
	}

	public static boolean checkMainPageExist(String account) {
		return userDAO.checkMainPageExist(account);
	}

	public static boolean checkRecordPageExist(String account, String ontime) {
		return userDAO.checkRecordPageExist(account,ontime);
	}

	public static boolean checkZhangwuPageExist(String account,String generatedtime) {
		return userDAO.checkZhangwuPageExist(account,generatedtime);
	}

	public static boolean checkPersonPageExist(String account,String userIPv4) {
		return userDAO.checkPersonPageExist(account,userIPv4);
	}

	public List<mainpage> MainPageServlet(String account) {
		return userDAO.MainPageServlet(account);
	}

	public List<netRecord> NetrecordServlet(String account) {
		return userDAO.NetrecordServlet(account);
	}

	public List<zhangWu> ZhangwuServlet(String account) {
		return userDAO.ZhangwuServlet(account);
	}

	public boolean addUser(User user) {
		return userDAO.addUser(user);
		
	}

	public static boolean checkAccountExist(String account) {
		return userDAO.checkAccountExist(account);
	}

	public List<User> ShowAllusers() {
		return userDAO.ShowAllusers();
	}

	public List<userInfo> PersonServlet(String account) {
		return userDAO.PersonServlet(account);
	}

	public static String findPassword(String account) {
		return userDAO.findPassword(account);
	}

	public boolean updatePassword(String account, String password2) {
		return userDAO.updatePassword(account,password2);
	}



	




	

}
