package cn.domain;

/** 
 * ClassName: zhangWu 
 * Function: TODO 用来封装锐捷流量系统的财务流水数据（财务流水）
 * date: 2016年12月2日 下午3:35:19 
 * @author 13信息_晚进军
 * @version 
 * @since JDK 1.7.0_51
 */
public class zhangWu {
	private int id;
	private String username;//用户名
	private String account;//账户名
	private String billsource;
	private String fee;//费用
	private String nowbalance;//当前余额
	private String nowwithhold;//当前代扣款
	private String generatedtime;//生成时间
	private String businessvolume;//业务量
	private String withholdrole;//扣费规则
	/*
	 * setter 和getter 方法
	 */
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getBillsource() {
		return billsource;
	}
	public void setBillsource(String billsource) {
		this.billsource = billsource;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getNowbalance() {
		return nowbalance;
	}
	public void setNowbalance(String nowbalance) {
		this.nowbalance = nowbalance;
	}
	public String getNowwithhold() {
		return nowwithhold;
	}
	public void setNowwithhold(String nowwithhold) {
		this.nowwithhold = nowwithhold;
	}
	public String getGeneratedtime() {
		return generatedtime;
	}
	public void setGeneratedtime(String generatedtime) {
		this.generatedtime = generatedtime;
	}
	public String getBusinessvolume() {
		return businessvolume;
	}
	public void setBusinessvolume(String businessvolume) {
		this.businessvolume = businessvolume;
	}
	public String getWithholdrole() {
		return withholdrole;
	}
	public void setWithholdrole(String withholdrole) {
		this.withholdrole = withholdrole;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
