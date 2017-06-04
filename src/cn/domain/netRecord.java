package cn.domain;
/** 
 * ClassName: netRecord 
 * Function: TODO 用来封装锐捷流量系统中的上网记录（上网记录）
 * date: 2016年12月2日 下午3:40:22 
 * @author 13信息_晚进军
 * @version 
 * @since JDK 1.7.0_51
 */
public class netRecord {
	private int id;
	private String account;//学号
	private String ontime;//上线时间
	private String offtime;//离线时间
	private String userIPv4;//用户IPv4
	private String service;//服务
	private String offreason;//离线原因
	private String oncost;//上网费用
	public String getOntime() {
		return ontime;
	}
	public void setOntime(String ontime) {
		this.ontime = ontime;
	}
	public String getOfftime() {
		return offtime;
	}
	public void setOfftime(String offtime) {
		this.offtime = offtime;
	}
	public String getUserIPv4() {
		return userIPv4;
	}
	public void setUserIPv4(String userIPv4) {
		this.userIPv4 = userIPv4;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getOffreason() {
		return offreason;
	}
	public void setOffreason(String offreason) {
		this.offreason = offreason;
	}
	public String getOncost() {
		return oncost;
	}
	public void setOncost(String oncost) {
		this.oncost = oncost;
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
