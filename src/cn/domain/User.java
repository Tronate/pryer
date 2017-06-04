package cn.domain;

/** 
 * ClassName: User 
 * Function: 用来封装用户输入的账号密码
 * date: 2016年12月2日 下午3:36:50 
 * @author 13信息_晚进军
 * @version 
 * @since JDK 1.7.0_51
 */
public class User {
private int id;
private String account; //学号
private String password;//锐捷流量系统密码
/*
 * setter and getter method
 */
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
}
