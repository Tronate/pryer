package cn.dao;

import java.util.List;

import cn.domain.User;
import cn.domain.mainpage;
import cn.domain.netRecord;
import cn.domain.userInfo;
import cn.domain.zhangWu;

/*
 * 
 * ClassName: UserDao 
 * Function: TODO 和用户相关的数据库操作，
 * date: 2016年12月2日 下午8:53:08 
 * @author 晚进军 Mr.Golden.Wan
 * @version 
 * @since JDK 1.7.0_51
 */

public interface UserDao {
	//添加用户主页信息
	boolean addMainpage(mainpage main);
	//添加用户的上网记录
	boolean addMainpage(netRecord record);
	//添加用户的自助账单
//	boolean addSelfBillPage(selfBill selfbill);
	//添加用户的账务流水信息
	boolean addZhangWupage(zhangWu zhangwu);
	//添加用户资料信息
	boolean addUserInfo(userInfo user);
	//查看用户主页信息是否存在
	boolean checkMainPageExist(String account);
	//查看用户的上网记录是否存在
	boolean checkRecordPageExist(String account, String ontime);
    //查看用户的账务流水是否存在 最近15条
	boolean checkZhangwuPageExist(String account,String generatedtime);
	//查看个人信息是否存在
	boolean checkPersonPageExist(String account,String userIPv4);
	//查看用户的主页信息
	List<mainpage> MainPageServlet(String account);
	//查看用户的上网记录
	List<netRecord> NetrecordServlet(String account);
	//添加用户账号密码
	boolean addUser(User user);
	//查看用户是否存在
	boolean checkAccountExist(String account);
	//查找所有用户
	List<User> ShowAllusers();
	//查找用户的账务流水 最近15条
	List<zhangWu> ZhangwuServlet(String account);
	//查找个人信息
	List<userInfo> PersonServlet(String account);
	//查找用户的密码
	String findPassword(String account);
	//修改用户的密码：新密码
	boolean updatePassword(String account, String password2);
}
