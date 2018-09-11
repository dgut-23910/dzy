package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseDao {
	public static String drv;//数据库类型
	public static String url;//数据库网址
	public static String usr;//用户名
	public static String pwd;//密码
	
	private Connection connect = null;
	private Statement stmt=null;
	private ResultSet rs = null;
	
	//构造函数，连接到数据库
	public DataBaseDao()  throws Exception{
		Class.forName(drv);
		connect = DriverManager.getConnection(url, usr, pwd);
		stmt = connect.createStatement();	
		//System.out.println("successful");
	}
	//执行查询
	public void  query(String sql) throws SQLException{
		rs = stmt.executeQuery(sql);
	}
	
	////rs的下一条记录是否存在
	public boolean next() throws SQLException{
		return rs.next();
	}
	//获取字符串类型字段的值
	public String getString(String field) throws SQLException{
		return rs.getString(field);
	}
	//获取整数类型字段的值
	public Integer getInt(String field) throws SQLException{
		return rs.getInt(field);
	}

	//获取实数类型字段的值
	public Double getDouble(String field) throws SQLException{
		return rs.getDouble(field);
	}
	
	
	public boolean hasId(String tableName, Integer id) throws SQLException{
		tableName=tableName.toLowerCase();
		String sql="select * from "+tableName+" where "+tableName+"Id="+id.toString();
		query(sql);
		while(next()){
			return true;
		}
		return false;
	}
	
	public void getById(String tableName, Integer id) throws SQLException{
		tableName=tableName.toLowerCase();
		String sql="select * from "+tableName+" where "+tableName+"Id="+id.toString();
		query(sql);
	}

	public Connection getConnect() {
		return connect;
	}

	public void setConnect(Connection connect) {
		this.connect = connect;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
}
