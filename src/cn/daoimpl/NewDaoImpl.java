package cn.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.dao.NewDao;
import cn.domain.mainpage;
import cn.utils.JdbcUtils;

public class NewDaoImpl implements NewDao {

	@Override
	public String findPackageflow(String account) {
		String packageflow = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from tb_mainpage where account=? ";
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				packageflow = rs.getString(7);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}

		return packageflow;
	}

	@Override
	public boolean updateMainPage(String account, String status,
			String accountway, String cycleTime, String balance,
			String packageflow, String withhold) {
		boolean flag1 = false;
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update tb_mainpage set status=?,accountway=?, cycleTime=?, balance=?,packageflow=?, withhold=? where account=?";
			st = conn.prepareStatement(sql);
			st.setString(1, status);
			st.setString(2, accountway);
			st.setString(3, cycleTime);
			st.setString(4, balance);
			st.setString(5, packageflow);
			st.setString(6, withhold);
			st.setString(7, account);

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

	@Override
	public List<mainpage> ShowAllMainPage() {
		List<mainpage> mainpagelists = new ArrayList<mainpage>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from tb_mainpage ";
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				mainpage mainpages = new mainpage();
				mainpages.setId(rs.getInt(1));
				mainpages.setAccount(rs.getString(2));
				mainpages.setStatus(rs.getString(3));
				mainpages.setAccountway(rs.getString(4));
				mainpages.setCycleTime(rs.getString(5));
				mainpages.setBalance(rs.getString(6));
				mainpages.setPackageflow(rs.getString(7));
				mainpages.setWithhold(rs.getString(8));
				mainpagelists.add(mainpages);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		return mainpagelists;
	}

	@Override
	public void addTime(long l) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "insert into tb_time values(null,null,?)";
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, l);
			pstmt.execute();

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
	}

	@Override
	public String findCycleTime(String account) {
		String CycleTime = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from tb_mainpage where account=? ";
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);

			rs = pstmt.executeQuery();
			if (rs.next()) {

				CycleTime = rs.getString(5);

			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		return CycleTime;
	}
}
