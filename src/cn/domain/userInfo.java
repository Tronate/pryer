package cn.domain;
/**
 * 
 * ClassName: userInfo 
 * Function: 用于封装锐捷网络流量里面的个人信息（个人信息）
 * date: 2016年12月2日 下午3:27:07 
 * @author 13信息_晚进军
 * @version 
 * @since JDK 1.7.0_51
 */
public class userInfo {
private int id;
private String account;
private String username;//用户名称
private String password;//密码，默认******

private String sex;//性别

private String zjh;//֤证件号

private String userIPv4;//用户IPV4

private String connway; //接入方式

private String balance;//余额
private String withholding;//待扣款(元)
private String status;//状态


/*
 * 创建相应的setter和getter方法
 */
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}

public String getZjh() {
	return zjh;
}
public void setZjh(String zjh) {
	this.zjh = zjh;
}
public String getUserIPv4() {
	return userIPv4;
}
public void setUserIPv4(String userIPv4) {
	this.userIPv4 = userIPv4;
}
public String getConnway() {
	return connway;
}
public void setConnway(String connway) {
	this.connway = connway;
}
public String getBalance() {
	return balance;
}
public void setBalance(String balance) {
	this.balance = balance;
}
public String getWithholding() {
	return withholding;
}
public void setWithholding(String withholding) {
	this.withholding = withholding;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
}