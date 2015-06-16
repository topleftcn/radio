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
	 * �����ݿ���ɾ����Ŀ��
	 * @param id Ҫɾ���������ݵ�id
	 * @return ����int,1 -- �ɹ�; 0 -- ʧ��
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
	 * ���ҳ����еĽ�Ŀ����Ϣ
	 * @return ����һ��ArrayList_Column����
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
