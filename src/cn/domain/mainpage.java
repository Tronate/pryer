package cn.domain;
/*
 * 
 * ClassName: mainpage 
 * Function: TODO 用来封装锐捷流量系统里面的首页信息. （基本信息）
 * date: 2016年12月2日 下午3:43:04 
 * @author 13信息_晚进军
 * @version 
 * @since JDK 1.7.0_51
 */
public class mainpage {

private int id;
private String account;//学号
private String status;//用户状态
private String accountway;//计费策略
private String cycleTime;//周期时间范围
private String balance;//余额
private String packageflow;//套餐流量
private String withhold;//待扣款
/*
 * setter and getter method
 */
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getAccountway() {
	return accountway;
}
public void setAccountway(String accountway) {
	this.accountway = accountway;
}
public String getCycleTime() {
	return cycleTime;
}
public void setCycleTime(String cycleTime) {
	this.cycleTime = cycleTime;
}
public String getBalance() {
	return balance;
}
public void setBalance(String balance) {
	this.balance = balance;
}
public String getPackageflow() {
	return packageflow;
}
public void setPackageflow(String packageflow) {
	this.packageflow = packageflow;
}
public String getWithhold() {
	return withhold;
}
public void setWithhold(String withhold) {
	this.withhold = withhold;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
}
