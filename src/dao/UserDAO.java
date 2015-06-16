package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

public class UserDAO extends BaseDAO{

	/**
	 * 通过用户名来查找用户信息
	 * @param username 传递过来的用户名
	 * @return 返回一个User对象
	 */
	public User findByName(String username){
		
		String sql = "SELECT * FROM `user` WHERE username = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User u = new User();
		
		try {
			 conn = this.getConnection();
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, username);
			 rs = pstmt.executeQuery();
			 if( rs.next() ){
				 u.setId( rs.getInt("id") );
				 u.setPassword( rs.getString("password") );
				 u.setUsername( rs.getString("username") );
			 }else{
				 return null;
			 }
			 return u;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			try {
				if( pstmt!=null) pstmt.close();
				if( conn != null ) conn.close();
				if( rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
