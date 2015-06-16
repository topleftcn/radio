package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.AllTitle;
import entity.Bottom;
import entity.Column;
import entity.Index;

public class AllTitleDAO extends BaseDAO{
	/**
	 * 在数据库中删除蓝目标
	 * @param id 要删除那条数据的id
	 * @return 返回int,1 -- 成功; 0 -- 失败
	 */
	public int update(int type,String title,String content,String picture){
		String sql = "UPDATE `alltitle` SET title=?,content=?,picture=? WHERE type = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, picture);
			pstmt.setInt(4, type);
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally{
			try {
				if( pstmt!=null) pstmt.close();
				if( conn != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 查找出所有的节目表信息
	 * @return 返回一个ArrayList_Column对象
	 */
	public ArrayList<AllTitle> findAllTitle(int type){
		String sql = "SELECT * FROM `alltitle` WHERE `type` = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<AllTitle> list = new ArrayList<AllTitle>();

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, type);
			rs = pstmt.executeQuery();
			while( rs.next() ){
				AllTitle b = new AllTitle();
				b.setId( rs.getInt("id") );
				b.setType( rs.getInt("type") );
				b.setTitle( rs.getString("title"));
				b.setContent(rs.getString("content"));
				b.setPicture( rs.getString("picture"));
				list.add(b);
			}
			return list;
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

	public int AllTitleInsert(AllTitle b){
		String sql = "INSERT INTO `AllTitle` VALUES(NULL,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getType() );
			pstmt.setString(2, b.getTitle() );
			pstmt.setString(3, b.getContent() );
			pstmt.setString(4, b.getPicture() );
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
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
