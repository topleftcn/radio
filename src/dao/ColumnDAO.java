package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Column;

public class ColumnDAO extends BaseDAO{

	/**
	 * ���ҳ����еĽ�Ŀ����Ϣ
	 * @return ����һ��ArrayList_Column����
	 */
	public ArrayList<Column> findAllColumn(){

		String sql = "SELECT * FROM `column`";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Column> list = new ArrayList<Column>();

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while( rs.next() ){
				Column c = new Column();
				c.setId( rs.getInt("id") );
				c.setTitle( rs.getString("title") );
				c.setContent( rs.getString("content") );
				c.setColumntime( rs.getString("columntime") );
				c.setInserttime( rs.getString("inserttime") );
				list.add(c);
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

	/**
	 * �����ݿ���ɾ����Ŀ��
	 * @param id Ҫɾ���������ݵ�id
	 * @return ����int,1 -- �ɹ�; 0 -- ʧ��
	 */
	public int deleteColumn(int id){
		String sql = "DELETE FROM `column` WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
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
	 * ����ҳ�������в�ѯ��Ŀ��Ϣ
	 * @param pages ���ݹ�����ҳ��
	 * @return
	 */
	public ArrayList<Column> findAllColumn(int pages){
		String sql = "SELECT * FROM `column` LIMIT ?,8";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Column> list = new ArrayList<Column>();

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pages-1)*8 );
			rs = pstmt.executeQuery();
			while( rs.next() ){
				Column c = new Column();
				c.setId( rs.getInt("id") );
				c.setTitle( rs.getString("title") );
				c.setContent( rs.getString("content") );
				c.setColumntime( rs.getString("columntime") );
				c.setInserttime( rs.getString("inserttime") );
				list.add(c);
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
	
	public ArrayList<Column> findAllColumn1(int pages){
		String sql = "SELECT * FROM `column`";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Column> list = new ArrayList<Column>();

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pages-1)*8 );
			rs = pstmt.executeQuery();
			while( rs.next() ){
				Column c = new Column();
				c.setId( rs.getInt("id") );
				c.setTitle( rs.getString("title") );
				c.setContent( rs.getString("content") );
				c.setColumntime( rs.getString("columntime") );
				c.setInserttime( rs.getString("inserttime") );
				list.add(c);
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
	
	/**
	 * ��Ŀ���ۼӺ�
	 * @return ���غ�
	 */
	public int getTotal(){
		String sql = "SELECT count(*) AS total FROM `column`";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int index = 0;
			if( rs.next() )
				index =  rs.getInt("total");
			return index;
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
	
	/**
	 * ����Ŀ�в�������
	 * @param c ���ݹ�������Ŀ��Ϣ
	 * @return ����1--�ɹ�,0--ʧ��
	 */
	public int ColumnInsert(Column c){
		
		String sql = "INSERT INTO `column` VALUES(NULL,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getTitle() );
			pstmt.setString(2, c.getContent() );
			pstmt.setString(3, c.getColumntime() );
			pstmt.setString(4, c.getInserttime() );
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
