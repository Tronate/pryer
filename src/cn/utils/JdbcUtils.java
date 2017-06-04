package cn.utils;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JdbcUtils {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	static {
		//配置文件必须放在src目录下
		driver = ResourceBundle.getBundle("db").getString("driver");
		url =  ResourceBundle.getBundle("db").getString("url");
		password = ResourceBundle.getBundle("db").getString("password");
		username = ResourceBundle.getBundle("db").getString("username");
	}
	public static Connection getConnection() throws SQLException {
		loadDriver();
		return DriverManager.getConnection(url,username,password);
	}
	private static void loadDriver() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库驱动加载失败！");
		}
	}	
	public static void release(Connection conn,Statement st,ResultSet rs){	
		if(rs!=null){
			try{
				rs.close(); 
			}catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if(st!=null){
			try{
				st.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			st = null;
		}
		if(conn!=null){
			try{
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}
}	


