package cn.dao;

import java.util.List;

import cn.domain.mainpage;

public interface NewDao {

	String findPackageflow(String account);

	boolean  updateMainPage(String account, String status, String accountway,
			String cycleTime, String balance, String packageflow,
			String withhold);

	List<mainpage> ShowAllMainPage();

	void addTime(long l);

	String findCycleTime(String account);

}
