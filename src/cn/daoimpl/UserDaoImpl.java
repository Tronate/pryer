package cn.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.dao.UserDao;
import cn.domain.User;
import cn.domain.mainpage;
import cn.domain.netRecord;
import cn.domain.userInfo;
import cn.domain.zhangWu;
import cn.utils.JdbcUtils;

/**
 * 
 * ClassName: UserDaoImpl 
 * Function: TODO dao 实现类，实现和用户相关的数据库操作
 * date: 2016年12月2日 下午9:07:17 
 * @author 晚进军 Mr.Golden.Wan
 * @version 
 * @since JDK 1.7.0_51
 */

public class UserDaoImpl implements UserDao {
	//添加用户主页信息
	@Override
	public boolean addMainpage(mainpage main) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "insert into tb_mainpage values(null,?,?,?,?,?,?,?)";
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, main.getAccount());
			pstmt.setString(2, main.getStatus());
			pstmt.setString(3, main.getAccountway());
			pstmt.setString(4, main.getCycleTime());
			pstmt.setString(5, main.getBalance());
			pstmt.setString(6, main.getPackageflow());
			pstmt.setString(7, main.getWithhold());

			boolean i = pstmt.execute();
			if (i != false) {

				flag = true;

			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		return flag;

	}
	//添加用户的上网记录

	@Override
	public boolean addMainpage(netRecord record) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "insert into tb_netrecord values(null,?,?,?,?,?,?,?)";
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, record.getAccount());
			pstmt.setString(2, record.getOntime());
			pstmt.setString(3, record.getOfftime());
			pstmt.setString(4, record.getUserIPv4());
			pstmt.setString(5, record.getService());
			pstmt.setString(6, record.getOffreason());
			pstmt.setString(7, record.getOncost());

			boolean i = pstmt.execute();
			if (i != false) {

				flag = true;

			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		return flag;
	}
	//添加用户的自助账单

/*	@Override
	public boolean addSelfBillPage(selfBill selfbill) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "insert into tb_selfbill values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, selfbill.getUsername());
			pstmt.setString(2, selfbill.getStatus());
			pstmt.setString(3, selfbill.getBillway());
			pstmt.setString(4, selfbill.getPeriod());
			pstmt.setString(5, selfbill.getBalance());
			pstmt.setString(6, selfbill.getWithhold());
			pstmt.setString(7, selfbill.getPackageflow());
			pstmt.setString(8, selfbill.getBeginbalance());
			pstmt.setString(9, selfbill.getNowbalance());
			pstmt.setString(10, selfbill.getEnterbill());
			pstmt.setString(11, selfbill.getOutbill());
			pstmt.setString(12, selfbill.getUsedflow());
			pstmt.setString(13, selfbill.getUsableflow());
			pstmt.setString(14, selfbill.getRoledescribe());
			pstmt.setString(15, selfbill.getOffsetexplain());
			int i = pstmt.executeUpdate();
			if (i != 0) {

				flag = true;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		return flag;
	}*/
	//添加用户的财务流水信息

	@Override
	public boolean addZhangWupage(zhangWu zhangwu) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "insert into tb_zhangwu values(null,?,?,?,?,?,?,?,?,?)";
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, zhangwu.getUsername());
			pstmt.setString(2, zhangwu.getAccount());
			pstmt.setString(3, zhangwu.getBillsource());
			pstmt.setString(4, zhangwu.getFee());
			pstmt.setString(5, zhangwu.getNowbalance());
			pstmt.setString(6, zhangwu.getNowwithhold());
			pstmt.setString(7, zhangwu.getGeneratedtime());
			pstmt.setString(8, zhangwu.getBusinessvolume());
			pstmt.setString(9, zhangwu.getWithholdrole());
			int i = pstmt.executeUpdate();
			if (i != 0) {

				flag = true;

			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		return flag;
	}
	//添加用户资料信息

	@Override
	public boolean addUserInfo(userInfo user) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "insert into tb_userinfo values(null,?,?,?,?,?,?,?,?,?,?)";
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getAccount());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getSex());
			pstmt.setString(5, user.getZjh());
			pstmt.setString(6, user.getUserIPv4());
			pstmt.setString(7, user.getConnway());
			pstmt.setString(8, user.getBalance());
			pstmt.setString(9, user.getWithholding());
			pstmt.setString(10, user.getStatus());

			int i = pstmt.executeUpdate();
			if (i != 0) {

				flag = true;

			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		return flag;
	}
	//查看用户主页信息是否存在

	@Override
	public boolean checkMainPageExist(String account) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from tb_mainpage where account=?";
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;

			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		return flag;
	}
	//查看用户的上网记录是否存在

	@Override
	public boolean checkRecordPageExist(String account, String ontime) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from tb_netrecord where account=? and ontime =?";
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.setString(2, ontime);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		return flag;
	}

	@Override
	public boolean checkZhangwuPageExist(String account, String generatedtime) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from tb_zhangwu where account=? and generatedtime=? limit 0,15";
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.setString(2, generatedtime);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;

			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		return flag;
	}

	@Override
	public boolean checkPersonPageExist(String account, String userIPv4) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from tb_userinfo where account=? and userIPv4=?";
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.setString(2, userIPv4);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;

			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		return flag;
	}
	/**
	 * 将数据库的首页信息返回给mainpage的Servlet
	 * */
	@Override
	public List<mainpage> MainPageServlet(String account) {
		List<mainpage> mainpageList = new ArrayList<mainpage>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from tb_mainpage where account=? order by id desc ";
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				mainpage maininfo = new mainpage();
				maininfo.setId(rs.getInt(1));
				maininfo.setAccount(rs.getString(2));
				maininfo.setStatus(rs.getString(3));
				maininfo.setAccountway(rs.getString(4));
				maininfo.setCycleTime(rs.getString(5));
				maininfo.setBalance(rs.getString(6));
				maininfo.setPackageflow(rs.getString(7));
				maininfo.setWithhold(rs.getString(8));
				mainpageList.add(maininfo);

			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}

		return mainpageList;
	}

	@Override
	public List<netRecord> NetrecordServlet(String account) {
		List<netRecord> netrecordList = new ArrayList<netRecord>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from tb_netrecord where  account=? order by ontime desc limit 0,15 ";
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				netRecord records = new netRecord();
				records.setId(rs.getInt(1));
				records.setAccount(rs.getString(2));
				records.setOntime(rs.getString(3));
				records.setOfftime(rs.getString(4));
				records.setUserIPv4(rs.getString(5));
				records.setService(rs.getString(6));
				records.setOffreason(rs.getString(7));
				records.setOncost(rs.getString(8));
				netrecordList.add(records);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		return netrecordList;
	}
	//查看用户的财务流水是否存在 最近15条
	@Override
	public List<zhangWu> ZhangwuServlet(String account) {
		List<zhangWu> zhangwuList = new ArrayList<zhangWu>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from tb_zhangwu where account=? order by generatedtime desc limit 0,15";
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				zhangWu zhangwu = new zhangWu();
				zhangwu.setId(rs.getInt(1));
				zhangwu.setUsername(rs.getString(2));
				zhangwu.setAccount(rs.getString(3));
				zhangwu.setBillsource(rs.getString(4));
				zhangwu.setFee(rs.getString(5));
				zhangwu.setNowbalance(rs.getString(6));
				zhangwu.setNowwithhold(rs.getString(7));
				zhangwu.setGeneratedtime(rs.getString(8));
				zhangwu.setBusinessvolume(rs.getString(9));
				zhangwu.setWithholdrole(rs.getString(10));
				zhangwuList.add(zhangwu);

			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		return zhangwuList;
	}

	@Override
	public boolean addUser(User user) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "insert into tb_user values(null,?,?)";
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getAccount());
			pstmt.setString(2, user.getPassword());
			int i = pstmt.executeUpdate();
			if (i != 0) {
				flag = true;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		return flag;

	}

	@Override
	public boolean checkAccountExist(String account) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from tb_user where account=?";
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		return flag;
	}

	@Override
	public List<User> ShowAllusers() {
		List<User> userlist = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from tb_user ";
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User users = new User();
				users.setId(rs.getInt(1));
				users.setAccount(rs.getString(2));
				users.setPassword(rs.getString(3));
				userlist.add(users);

			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		return userlist;
	}

	@Override
	public List<userInfo> PersonServlet(String account) {
		List<userInfo> usersList = new ArrayList<userInfo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {//查询最新个人信息
			String sql = "select * from tb_userinfo where account=? order by id desc ";
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				userInfo userinfo = new userInfo();
				userinfo.setId(rs.getInt(1));
				userinfo.setAccount(rs.getString(2));
				userinfo.setUsername(rs.getString(3));
				userinfo.setPassword(rs.getString(4));
				userinfo.setSex(rs.getString(5));
				userinfo.setZjh(rs.getString(6));
				userinfo.setUserIPv4(rs.getString(7));
				userinfo.setConnway(rs.getString(8));
				userinfo.setBalance(rs.getString(9));
				userinfo.setWithholding(rs.getString(10));
				userinfo.setStatus(rs.getString(11));
				usersList.add(userinfo);

			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		return usersList;
	}

	@Override
	public String findPassword(String account) {
		String psd = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from tb_user where account=?";
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				psd = rs.getString(3);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}

		return psd;
	}

	@Override
	public boolean updatePassword(String account, String password2) {
		boolean flag1 = false;
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update tb_user set password=?  where account=?";
			st = conn.prepareStatement(sql);
			st.setString(1, password2);
			st.setString(2, account);
			int flag = st.executeUpdate();
			if (flag != 0) {
				flag1 = true;
			}
			return flag1;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(conn, st, rs);
		}
	}
}
